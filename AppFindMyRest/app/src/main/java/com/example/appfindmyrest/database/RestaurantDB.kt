package com.example.appfindmyrest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appfindmyrest.models.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDB: RoomDatabase() {
    abstract fun getRestaurantDAO() : RestaurantDAO

    companion object {

        private var INSTANCE : RestaurantDB?= null

        fun getInstance(context: Context) : RestaurantDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, RestaurantDB::class.java, "restaurant.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as RestaurantDB
        }
    }
}