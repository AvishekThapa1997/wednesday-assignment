package com.app.wednesdayassignment.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class Singer(
    @ColumnInfo(name = "singer_name")
    val name: String,
    @ColumnInfo(name = "singer_songs")
    val songs: List<Song>,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
)