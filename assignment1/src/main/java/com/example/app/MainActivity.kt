package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateView()

        findViewById<Button>(R.id.next_button).setOnClickListener{
            if (questionIndex != 19){
                questionIndex++
            }else{
                questionIndex = 0
            }
            updateView()
        }

        findViewById<Button>(R.id.prev_button).setOnClickListener{
            if (questionIndex != 0){
                questionIndex--
            }else{
                questionIndex = questionBank.size - 1
            }
            updateView()
        }

        findViewById<Button>(R.id.true_button).setOnClickListener{
            if (questionBank[questionIndex].answer){
                Toast.makeText(this, "You're right!",
                    Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "You're incorrect!",
                    Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.false_button).setOnClickListener{
            if (!questionBank[questionIndex].answer){
                Toast.makeText(this, "You're right!",
                    Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "You're incorrect!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateView(){
        findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].resourceId)
    }

}
