package com.myalbums.services

import com.myalbums.entities.Album
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("albums")
    fun getAlbum(@Query("format")format: String): Call<Album>
}