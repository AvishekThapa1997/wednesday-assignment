package com.app.wednesdayassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.app.wednesdayassignment.databinding.RecyclerViewLayoutBinding
import com.app.wednesdayassignment.helper.SongItemCallback
import com.app.wednesdayassignment.pojo.Song
import com.app.wednesdayassignment.viewholder.SongViewHolder

class SongsAdapter : RecyclerView.Adapter<SongViewHolder>() {
    private val asyncListDiffer: AsyncListDiffer<Song> = AsyncListDiffer(this, SongItemCallback())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongViewHolder(
        RecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position].songThumbnail)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun getItemId(position: Int) = position.toLong()

    fun submitList(data: List<Song>) {
        asyncListDiffer.submitList(data)
    }
}