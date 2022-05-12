package com.example.appfindmyrest.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.appfindmyrest.R
import com.example.appfindmyrest.controller.activities.RestaurantDetail
import com.example.appfindmyrest.database.RestaurantDB
import com.example.appfindmyrest.models.Restaurant
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class RestaurantAdapterFavorite(val restaurants: List<Restaurant>): RecyclerView.Adapter<RestaurantPrototypeFavorite>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantPrototypeFavorite {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_restaurant_favorite, parent, false)

        return RestaurantPrototypeFavorite(view)
    }

    override fun onBindViewHolder(prototype: RestaurantPrototypeFavorite, position: Int) {
        prototype.bind(restaurants[position])
        prototype.reaction(restaurants[position])
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}

class RestaurantPrototypeFavorite(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(restaurant: Restaurant) {
        tvTitle.text = restaurant.name
        tvAddress.text = restaurant.address
        tvDistrict.text = restaurant.district

        val picBuilder = Picasso.Builder(itemView.context)
        picBuilder.downloader(OkHttp3Downloader(itemView.context))
        picBuilder.build().load(restaurant.poster).into(ivLogo)

    }

    fun reaction(restaurant: Restaurant){
        btNoFavorite.setOnClickListener{
            //Log.d("Hola","funciona")

            if (restaurant != null){
                RestaurantDB.getInstance(itemView.context).getRestaurantDAO().deleteRestaurant(restaurant)
                Log.d("Urgente","Eliminado favorito vuelva atras para comprobar")
            }


        }
    }

    val ivLogo = itemView.findViewById<ImageView>(R.id.ivLogo)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val btNoFavorite = itemView.findViewById<Button>(R.id.btUnlike)
    val tvDistrict = itemView.findViewById<TextView>(R.id.tvDistrict)
    val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)

    //val cvRestaurant = itemView.findViewById<CardView>(R.id.cvRestaurant)

}
