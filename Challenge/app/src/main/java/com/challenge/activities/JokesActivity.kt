package com.challenge.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.R
import com.challenge.adapters.JokeAdapter
import com.challenge.entities.Joke
import com.challenge.services.JokeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokesActivity : AppCompatActivity() {
    var jokes = ArrayList<Joke>()
    var jokeAdapter = JokeAdapter(jokes)
    //var mostRankedJoke

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)
        loadJokes()
        initView()
    }

    private fun initView() {
         val rvJokes = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvJokes)

        rvJokes.adapter = jokeAdapter
        rvJokes.layoutManager = LinearLayoutManager(this)
    }

    private fun loadJokes() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService: JokeService
        jokeService = retrofit.create(JokeService::class.java)

        val request = jokeService.getJoke("json")

        request.enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {

            }

        })

        jokes.add(Joke(
            "abc",
            "https://geek-jokes.sameerkumar.website/api?format=json",
            20220510153213,
            "Chuck Norris can't test for equality because he has no equal.",
            0.0F)
        )
        jokes.add(Joke(
            "abd",
            "https://geek-jokes.sameerkumar.website/api?format=json",
            20220510153328,
            "Chuck Norris can do a roundhouse kick faster than the speed of light. This means that if you turn on a light switch, you will be dead before the lightbulb turns on.",
            0.0F)
        )
        jokes.add(Joke(
            "abe",
            "https://geek-jokes.sameerkumar.website/api?format=json",
            20220510153524,
            "How much wood would a woodchuck chuck if a woodchuck could Chuck Norris? All of it.",
            0.0F)
        )
    }


    //Asigna el menu a la actividad
    //Ctrl+O
    //onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.jokes_menu, menu)
        return true
    }
    //Acciones del menu
    //Ctrl+O
    //onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}