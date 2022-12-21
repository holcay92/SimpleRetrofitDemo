package com.example.simpleretrofitdemo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    // endpoint is /albums
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
    // suspend is related to coroutines!!

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId:Int): Response<Albums>
}