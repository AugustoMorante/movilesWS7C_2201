package com.challenge.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.R
import com.challenge.adapters.ReciclerAdapter
import com.challenge.entities.Reciclador

class ReciclerActivity : AppCompatActivity() {
    var reciclers = ArrayList<Reciclador>()
    var reciclerAdapter = ReciclerAdapter(reciclers)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler)

        loadReciclers()
        initView()
    }

    private fun initView() {
        val rvRecicler = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvReciclers)

        rvRecicler.adapter = reciclerAdapter
        rvRecicler.layoutManager = LinearLayoutManager(this)
    }

    private fun loadReciclers() {
        reciclers.add(Reciclador("Armando"))
        reciclers.add(Reciclador("Jimmy"))
        reciclers.add(Reciclador("Juan"))
        reciclers.add(Reciclador("Pedro"))
        reciclers.add(Reciclador("Ricardo"))
    }
}