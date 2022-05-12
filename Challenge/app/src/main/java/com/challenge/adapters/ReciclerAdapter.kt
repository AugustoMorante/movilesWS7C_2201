package com.challenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.R
import com.challenge.entities.Reciclador
import java.util.ArrayList

class ReciclerAdapter(var reciclers: ArrayList<Reciclador>): RecyclerView.Adapter<ReciclerPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReciclerPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_recicler, parent, false)

        return ReciclerPrototype(view)
    }

    override fun onBindViewHolder(holder: ReciclerPrototype, position: Int) {
        holder.bind(reciclers.get(position))
    }

    override fun getItemCount(): Int {
        return reciclers.size
    }

}

class ReciclerPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvReciclerName = itemView.findViewById<android.widget.TextView>(R.id.tvReciclerName)

    fun bind(recicler: Reciclador) {
        tvReciclerName.text = recicler.name
    }
}
