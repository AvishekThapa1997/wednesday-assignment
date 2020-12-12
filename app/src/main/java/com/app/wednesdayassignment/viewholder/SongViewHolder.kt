package com.app.wednesdayassignment.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.app.wednesdayassignment.databinding.RecyclerViewLayoutBinding
import com.bumptech.glide.Glide

class SongViewHolder(private val recyclerViewLayoutBinding: RecyclerViewLayoutBinding) :
    RecyclerView.ViewHolder(recyclerViewLayoutBinding.root) {

    fun bind(songThumbnail: String) {
        Glide.with(recyclerViewLayoutBinding.root.context).load(songThumbnail)
            .into(recyclerViewLayoutBinding.ivSongThumbnail)
    }
}