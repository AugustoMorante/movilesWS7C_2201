package com.challenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.entities.Joke

@Database(entities = [Joke::class], version = 1)
abstract class JokeDB: RoomDatabase() {
    abstract fun getRestaurantDAO() : JokeDAO

    companion object {

        private var INSTANCE : JokeDB?= null

        fun getInstance(context: Context) : JokeDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, JokeDB::class.java, "joke.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as JokeDB
        }
    }
}