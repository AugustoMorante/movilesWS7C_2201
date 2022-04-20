package com.example.app_sem04_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions(){
        questions=ArrayList()
        var question = Question("¿Es Arica capital de Bolivia?", false)
        questions.add(question)

        questions.add(Question("¿Es Arica capital de Lima?", false))
        questions.add(Question("¿Es Lima capital de Perú?", true))
        questions.add(Question("¿Es Santiago capital de Chile?", true))
        questions.add(Question("¿Es La Paz capital de Brasil?", false))
    }

    private fun setupViews(){
        var position = 0
        val btAfirmative = findViewById<Button>(R.id.btAfirmative)
        val btNegative = findViewById<Button>(R.id.btNegative)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val btNext = findViewById<Button>(R.id.btNext)

        tvQuestion.text = questions[position].sentence

        btAfirmative.setOnClickListener {
            if(questions[position].answer == true)
            {
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
            }
        }

        btNegative.setOnClickListener {
            if(questions[position].answer == false)
            {
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
            }
        }

        btNext.setOnClickListener {
            position++
            tvQuestion.text = questions[position].sentence
        }
    }
}