package com.app.wednesdayassignment.utility

sealed class NetworkApiResponse<T> {
    data class Success<T>(val data: T) : NetworkApiResponse<T>()
    data class Error<T>(val error: String) : NetworkApiResponse<T>()
}