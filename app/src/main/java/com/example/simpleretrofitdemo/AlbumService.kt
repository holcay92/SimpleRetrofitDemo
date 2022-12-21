package com.example.simpleretrofitdemo

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    // endpoint is /albums
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
    // suspend is related to coroutines!!
}