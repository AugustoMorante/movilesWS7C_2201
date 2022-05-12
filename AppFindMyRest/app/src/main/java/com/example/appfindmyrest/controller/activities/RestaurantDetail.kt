package com.example.appfindmyrest.controller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfindmyrest.R
import com.example.appfindmyrest.adapter.RestaurantAdapter
import com.example.appfindmyrest.adapter.RestaurantAdapterFavorite
import com.example.appfindmyrest.database.RestaurantDB
import com.example.appfindmyrest.models.Restaurant

class RestaurantDetail : AppCompatActivity() {
    var restaurant: List<Restaurant> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        restaurant = RestaurantDB.getInstance(this).getRestaurantDAO().getAllRestaurants()
        recyclerView = findViewById(R.id.rvRestaurantsSaved)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RestaurantAdapterFavorite(restaurant)
    }
}