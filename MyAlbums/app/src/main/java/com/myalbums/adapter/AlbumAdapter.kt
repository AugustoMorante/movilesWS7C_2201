package com.myalbums.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myalbums.R
import com.myalbums.entities.Album
import java.util.ArrayList

class AlbumAdapter(var albums: ArrayList<Album>): RecyclerView.Adapter<AlbumPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumPrototype {
        val view =LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_album, parent, false)
        return AlbumPrototype(view)
    }

    override fun onBindViewHolder(holder: AlbumPrototype, position: Int) {
        holder.bind(albums.get(position))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

}

class AlbumPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvId = itemView.findViewById<TextView>(R.id.tvId)
    val tvUserId = itemView.findViewById<TextView>(R.id.tvUserId)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

    fun bind(album: Album) {
        tvId.text = album.id.toString()
        tvUserId.text = album.userId.toString()
        tvTitle.text = album.title
    }
}
