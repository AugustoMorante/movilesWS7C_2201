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
        questions.add(Question("¿Es Arica capital de Bolivia?", false))
        questions.add(Question("¿Es Arica capital de Chile?", false))
        questions.add(Question("¿Es Lima capital de Perú?", true))
        questions.add(Question("¿Es Santiago capital de Chile?", true))
        questions.add(Question("¿Es La Paz capital de Brasil?", false))
        questions.add(Question("¿Es Santiago capital de Argentina?", false))
        questions.add(Question("¿Es Buenos Aires capital de Colombia?", false))
        questions.add(Question("¿Es La Paz capital de Bolivia?", true))
        questions.add(Question("¿Es Bogotá capital de Colombia?", true))
        questions.add(Question("¿Es Quito capital de Ecuador?", true))
    }

    private fun setupViews(){
        var position = 1
        var score = 0
        var lives = 3

        val questionsTotal = questions.size
        var questionSelection = (0 until (questions.size)).random()

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvLives = findViewById<TextView>(R.id.tvLives)
        val tvQuestionsLeft = findViewById<TextView>(R.id.tvQuestionNumber)

        val btAfirmative = findViewById<Button>(R.id.btAfirmative)
        val btNegative = findViewById<Button>(R.id.btNegative)

        val btNext = findViewById<Button>(R.id.btNext)

        btNext.isEnabled = false
        tvQuestion.text = questions[questionSelection].sentence
        tvScore.text = ("Puntaje: $score")
        tvLives.text = ("Vidas: $lives")
        tvQuestionsLeft.text = ("$position / $questionsTotal")

        btAfirmative.setOnClickListener {
            if(questions[questionSelection].answer)
            {
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
                score+=10
            }
            else{
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
                lives--
            }
            tvScore.text = ("Puntaje: $score")
            if(lives == 0){
                tvQuestion.text = "Juego terminado - Perdiste"
                btAfirmative.isEnabled = false
                btNegative.isEnabled = false
            }
            else{
                btAfirmative.isEnabled = false
                btNegative.isEnabled = false
                btNext.isEnabled = true
            }
            tvLives.text = ("Vidas: $lives")
        }

        btNegative.setOnClickListener {
            if(!questions[questionSelection].answer)
            {
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
                score+=10
            }
            else{
                Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
                lives--
            }
            tvScore.text = ("Puntaje: $score")
            if(lives == 0){
                tvQuestion.text = "Juego terminado - Perdiste"
                btAfirmative.isEnabled = false
                btNegative.isEnabled = false
            }
            else{
                btAfirmative.isEnabled = false
                btNegative.isEnabled = false
                btNext.isEnabled = true
            }
            tvLives.text = ("Vidas: $lives")
        }

        btNext.setOnClickListener {
            if (position!=questionsTotal){
                questions.remove(questions[questionSelection])
                questionSelection = (0 until (questions.size)).random()
                position++
                tvQuestionsLeft.text = ("$position / $questionsTotal")
                tvQuestion.text = questions[questionSelection].sentence
                btAfirmative.isEnabled = true
                btNegative.isEnabled = true
            }
            else{
                if(score == (questionsTotal*10)){
                    tvQuestion.text = "Juego terminado - Puntuacion: $score Perfecto :D"
                }
                else{
                    tvQuestion.text = "Juego terminado - Puntuacion: $score"
                }

            }
            btNext.isEnabled = false
        }
    }
}