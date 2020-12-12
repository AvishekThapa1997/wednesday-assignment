package com.app.wednesdayassignment.pojo

import com.google.gson.annotations.SerializedName

data class ApiResponse(@SerializedName("results") val songs: List<Song>)