package com.app.wednesdayassignment.api

import com.app.wednesdayassignment.pojo.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("search")
    suspend fun fetchData(@Query("term") singerName: String): Response<ApiResponse>
}