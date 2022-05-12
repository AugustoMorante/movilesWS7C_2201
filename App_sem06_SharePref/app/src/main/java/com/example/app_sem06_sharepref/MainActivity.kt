package com.example.app_sem06_sharepref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharePreferences = SharePreferences(this)

        val btSave =findViewById<Button>(R.id.btSave)
        val etName = findViewById<EditText>(R.id.tvEmail)
        val btRetrieve=findViewById<Button>(R.id.btShow)
        val tvRetrieve=findViewById<TextView>(R.id.tvRetrieve)


        btSave.setOnClickListener{
            val name = etName.text.toString()
            sharePreferences.save("name",name)
            Toast.makeText(this,"Data grabada",Toast.LENGTH_LONG).show()
        }

        btRetrieve.setOnClickListener{
            if (sharePreferences.getValue("name")!= null){
                
            }
        }

    }
}