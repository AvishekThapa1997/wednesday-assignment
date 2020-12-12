package com.app.wednesdayassignment.pojo

import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("artistName") val artistName: String,
    @SerializedName("collectionName") val collectionName : String,
    @SerializedName("trackName") val trackName : String,
    @SerializedName("artworkUrl100") val songThumbnail : String,
)