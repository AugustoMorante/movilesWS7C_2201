package com.example.appfindmyrest.controller.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfindmyrest.R
import com.example.appfindmyrest.adapter.RestaurantAdapter
import com.example.appfindmyrest.models.Restaurant
import com.example.appfindmyrest.network.RestaurantService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var restaurants:List<Restaurant>
    lateinit var restaurantAdapter: RestaurantAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btFloat = findViewById<FloatingActionButton>(R.id.fabFavorites)

        btFloat.setOnClickListener{
            val intent = Intent(this, RestaurantDetail::class.java)
            //intent.putExtra("Restaurant", restaurant)
            ContextCompat.startActivity(this, intent, null)
        }

        loadRestaurants(this)
    }

    private fun loadRestaurants(context: Context) {

        val rvRestaurant = findViewById<RecyclerView>(R.id.rvRestaurants)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://upc-pre-202102-cc183-parcial.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //DECLARAMOS NUESTRO OBJETO
        val restaurantService: RestaurantService
        restaurantService = retrofit.create(RestaurantService::class.java)

        val request = restaurantService.getRestaurants()

        request.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                if (response.isSuccessful) {
                    restaurants = response.body()!!

                    //Log.d("Activity Fail", Gson().toJson(restaurants))
                    restaurantAdapter = RestaurantAdapter(restaurants)
                    rvRestaurant.adapter = restaurantAdapter
                    rvRestaurant.layoutManager = LinearLayoutManager(context)
                }

                else{
                    Log.d("Activity Fail", "Error: "+response.code())
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.d("Activity Fail", "Error: $t")
            }



        }
        )
        }



    }
