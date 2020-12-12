package com.app.wednesdayassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.wednesdayassignment.pojo.Singer
import com.app.wednesdayassignment.pojo.Song
import com.app.wednesdayassignment.repository.DataRepository
import com.app.wednesdayassignment.utility.NetworkApiResponse
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _singer: MutableLiveData<NetworkApiResponse<Singer>> = MutableLiveData()
    val singer: LiveData<NetworkApiResponse<Singer>>
        get() = _singer

    fun fetchData(singerName: String) {
        viewModelScope.launch {
            val singer = dataRepository.fetchData(singerName)
            if (singer.songs.isNotEmpty()) {
                _singer.postValue(NetworkApiResponse.Success(singer))
            } else {
                _singer.postValue(NetworkApiResponse.Error("Something Went Wrong"))
            }
        }
    }
}