package com.example.app_sem05_recyclerview

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var contacts:ArrayList<Contact>):RecyclerView.Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_contact,parent,false)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bind(contacts.get(position))
    }

    override fun getItemCount(): Int {
        retun contacts.size
    }

}

class ContactPrototype(itemView: ActionMenuItemView):RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextureView>(R.id.tvName)
    val tvNumber = itemView.findViewById<TextureView>(R.id.tvNumber)

    fun bind(contact: Contact){
        tvName.text = contact.name
        tvNumber.text = contact.number
    }
}
