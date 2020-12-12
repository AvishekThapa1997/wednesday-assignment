package com.app.wednesdayassignment.ui

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.app.wednesdayassignment.adapter.SongsAdapter
import com.app.wednesdayassignment.databinding.ActivityMainBinding
import com.app.wednesdayassignment.utility.NetworkApiResponse
import com.app.wednesdayassignment.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var songsAdapter: SongsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        activityMainBinding.svSingerName.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { singerName ->
                    activityMainBinding.loadingProgress.visibility = View.VISIBLE
                    mainViewModel.fetchData(singerName.toLowerCase(Locale.ROOT))
                }
                return true
            }
        })
        songsAdapter = SongsAdapter()
        setUpRecyclerView()
        observeSongs()
    }

    private fun observeSongs() {
        mainViewModel.singer.observe(this) { networkApiResponse ->
            when (networkApiResponse) {
                is NetworkApiResponse.Success -> {
                    songsAdapter.submitList(networkApiResponse.data.songs)
                }
                is NetworkApiResponse.Error -> {
                    Snackbar.make(
                        activityMainBinding.root,
                        networkApiResponse.error,
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            activityMainBinding.loadingProgress.visibility = View.GONE
        }
    }
    private fun setUpRecyclerView() {
        activityMainBinding.songs.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = songsAdapter
        }
    }
}