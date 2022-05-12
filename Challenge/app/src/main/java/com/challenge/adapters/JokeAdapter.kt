package com.challenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.R
import com.challenge.entities.Joke
import com.challenge.entities.Reciclador
import java.util.ArrayList

class JokeAdapter(var jokes: ArrayList<Joke>): RecyclerView.Adapter<JokePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_joke, parent, false)

        return JokePrototype(view)
    }

    override fun onBindViewHolder(holder: JokePrototype, position: Int) {
        holder.bind(jokes.get(position))
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

}

class JokePrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvContent = itemView.findViewById<android.widget.TextView>(R.id.tvReciclerName)
    val rbJokeRating = itemView.findViewById<android.widget.RatingBar>(R.id.rbJokeRating)

    fun bind(joke: Joke) {
        tvContent.text = joke.content
        rbJokeRating.rating = joke.rating
    }
}
