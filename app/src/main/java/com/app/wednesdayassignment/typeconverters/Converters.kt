package com.app.wednesdayassignment.typeconverters

import androidx.room.TypeConverter
import com.app.wednesdayassignment.pojo.Song
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    val gson: Gson by lazy {
        Gson()
    }

    @JvmStatic
    @TypeConverter
    fun listToString(songs: List<Song>) = gson.toJson(songs)

    @JvmStatic
    @TypeConverter
    fun stringToList(songs: String): List<Song> {
        val typeToken = object : TypeToken<List<Song>>() {}.type
        return gson.fromJson(songs, typeToken)
    }
}