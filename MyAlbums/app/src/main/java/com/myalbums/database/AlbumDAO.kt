package com.myalbums.database

import androidx.room.*
import com.myalbums.entities.Album

@Dao
interface AlbumDAO {
    @Insert
    fun insertAlbum(vararg album: Album)

    @Query("SELECT * FROM album")
    fun getAllAlbums(): List<Album>

    @Delete
    fun deleteJoke(vararg album: Album)

}