package com.app.wednesdayassignment.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.wednesdayassignment.pojo.Singer
import com.app.wednesdayassignment.pojo.Song

@Dao
interface SingerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSinger(singer: Singer)

    @Query("SELECT * FROM songs WHERE singer_name LIKE :singerName")
    suspend fun findSongs(singerName: String): Singer?
}