package com.myalbums.activities

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.myalbums.R
import com.myalbums.adapter.AlbumAdapter
import com.myalbums.entities.Album

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id_xml = findViewById<EditText>(R.id.etId)
        val id = id_xml.text


        if (id.isNotEmpty()){
            val intent = Intent(this, ListsActivity::class.java)
            startActivity(intent)
            return super.onOptionsItemSelected(item)
        }
        else{
            Toast.makeText(this,"Inserte un Id",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun filterAlbum() {
        val id_xml = findViewById<EditText>(R.id.etId)
        val id = id_xml.text.toString()

        val intent = Intent()

        intent.putExtra("keyId", id)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }


}