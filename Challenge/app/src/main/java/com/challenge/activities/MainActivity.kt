package com.challenge.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.challenge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }

    private fun setupViews() {
        val tvBestJoke = findViewById<TextView>(R.id.tvBestJoke)
        val btJokes = findViewById<Button>(R.id.btJokes)

        btJokes.setOnClickListener {
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
    }
}