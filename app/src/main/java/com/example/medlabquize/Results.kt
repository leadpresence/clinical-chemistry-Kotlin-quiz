package com.example.medlabquize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medlabquize.Constants.CORRECT_ANSWER
import com.example.medlabquize.Constants.USERNAME
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_results.*

class Results : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        val score=intent.getIntExtra(CORRECT_ANSWER,0)
        val user_name=intent.getStringExtra(USERNAME)
        val total_questions=intent.getStringExtra(Constants.TOTAL_QUESION)

        username.text=user_name
        scoreText.text="You scored $score of $total_questions questions"

        finishButton.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}