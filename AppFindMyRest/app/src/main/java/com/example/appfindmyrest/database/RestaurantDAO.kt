package com.example.appfindmyrest.database

import androidx.room.*
import com.example.appfindmyrest.models.Restaurant

@Dao
interface RestaurantDAO {
    @Insert
    fun insertRestaurant(vararg restaurant: Restaurant)

    @Query("SELECT * FROM restaurants ")
    fun getAllRestaurants(): List<Restaurant>

    @Delete
    fun deleteRestaurant(vararg restaurant: Restaurant)

}