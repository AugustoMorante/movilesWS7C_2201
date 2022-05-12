package com.example.appfindmyrest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfindmyrest.R
import com.example.appfindmyrest.database.RestaurantDB
import com.example.appfindmyrest.models.Restaurant
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class RestaurantAdapter(val restaurants: List<Restaurant>): RecyclerView.Adapter<RestaurantPrototype>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_restaurant, parent, false)

        return RestaurantPrototype(view)
    }

    override fun onBindViewHolder(prototype: RestaurantPrototype, position: Int) {
        prototype.bind(restaurants[position])
        prototype.reaction(restaurants[position])
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}

class RestaurantPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(restaurant: Restaurant) {
        tvTitle.text = restaurant.name

        val picBuilder = Picasso.Builder(itemView.context)
        picBuilder.downloader(OkHttp3Downloader(itemView.context))
        picBuilder.build().load(restaurant.poster).into(ivLogo)

    }

    fun reaction(restaurant: Restaurant){
        btFavorite.setOnClickListener{
            //Log.d("Hola","funciona")

            if (restaurant != null){
                RestaurantDB.getInstance(itemView.context).getRestaurantDAO().insertRestaurant(restaurant)
            }


        }
    }

    val ivLogo = itemView.findViewById<ImageView>(R.id.ivLogo)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val btFavorite = itemView.findViewById<Button>(R.id.btUnlike)

    //val cvRestaurant = itemView.findViewById<CardView>(R.id.cvRestaurant)

}
