package com.myalbums.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myalbums.R
import com.myalbums.entities.Album

class MainActivity : AppCompatActivity() {
    /*var initialList = ArrayList<Album>()
    var albums = ArrayList<Album>()*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }


    private fun setupViews() {
        val btDetails = findViewById<android.widget.Button>(R.id.btDetails)
        val btLists = findViewById<android.widget.Button>(R.id.btLists)

        btDetails.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        btLists.setOnClickListener {
            val intent = Intent(this, ListsActivity::class.java)
            startActivity(intent)
        }
    }
}