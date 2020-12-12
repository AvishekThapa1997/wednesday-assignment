package com.app.wednesdayassignment.helper

import androidx.recyclerview.widget.DiffUtil
import com.app.wednesdayassignment.pojo.Song

class SongItemCallback : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song) = oldItem === newItem

    override fun areContentsTheSame(oldItem: Song, newItem: Song) = oldItem == newItem
}