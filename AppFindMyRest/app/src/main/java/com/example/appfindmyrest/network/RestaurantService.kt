package com.example.appfindmyrest.network

import com.example.appfindmyrest.models.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {
    @GET("restaurants")
    fun getRestaurants(): Call<List<Restaurant>>
}