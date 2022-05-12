package com.myalbums.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.myalbums.R
import com.myalbums.adapter.AlbumAdapter
import com.myalbums.entities.Album
import com.myalbums.services.AlbumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListsActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    var albums = ArrayList<Album>()
    var albumAdapter = AlbumAdapter(albums)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

        loadAlbums()
        //startActivityForResult(intent, REQUEST_CODE)
        initView()
    }

    private fun initView() {
        val rvAlmbums = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvList)
        rvAlmbums.adapter = albumAdapter
        rvAlmbums.layoutManager = LinearLayoutManager(this)
    }

    private fun loadAlbums() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val albumService: AlbumService
        albumService = retrofit.create(AlbumService::class.java)

        val request = albumService.getAlbum("json")

        request.enqueue(object : Callback<Album> {
            override fun onResponse(call: Call<Album>, response: Response<Album>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<Album>, t: Throwable) {

            }

        })

        albums.add(Album(1,1,"quidem molestiae enim"))
        albums.add(Album(1,2,"sunt qui excepturi placeat culpa"))
        albums.add(Album(1,3,"omnis laborum odio"))
        albums.add(Album(1,4,"non esse culpa molestiae omnis sed optio"))
        albums.add(Album(1,5,"aque aut omnis a"))
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.lists_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        albums.clear()
        initView()
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val id = data!!.getSerializableExtra("keyId")

                val filterAlbum = albums.find { it.id == id }
            }
        }
    }

}