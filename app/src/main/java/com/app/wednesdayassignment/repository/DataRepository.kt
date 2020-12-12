package com.app.wednesdayassignment.repository


import com.app.wednesdayassignment.api.NetworkApi
import com.app.wednesdayassignment.dao.SingerDao
import com.app.wednesdayassignment.pojo.Singer
import java.lang.Exception

class DataRepository(private val networkApi: NetworkApi, private val singerDao: SingerDao) {
    suspend fun fetchData(singerName: String): Singer {
        try {
            val response = networkApi.fetchData(singerName)
            if (response.isSuccessful && response.body() != null) {
                val singer = Singer(name = singerName, songs = response.body()!!.songs)
                singerDao.insertSinger(singer)
                return singer
            }
        } catch (exception: Exception) {
            return cachedData(singerName)
        }
        return Singer(singerName, emptyList())
    }

    suspend fun cachedData(singerName: String): Singer {
        val singer = singerDao.findSongs(singerName)
        if (singer != null) {
            return singer
        }
        return Singer(singerName, emptyList())
    }
}