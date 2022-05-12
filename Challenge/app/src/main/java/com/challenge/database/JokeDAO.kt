package com.challenge.database

import androidx.room.*
import com.challenge.entities.Joke

@Dao
interface JokeDAO {
    @Insert
    fun insertJoke(vararg joke: Joke)

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): List<Joke>

    @Delete
    fun deleteJoke(vararg joke: Joke)

}