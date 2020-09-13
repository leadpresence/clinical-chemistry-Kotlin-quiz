package com.example.medlabquize

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.medlabquize.Constants.USERNAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        buttonStart.setOnClickListener(){
            if(txtEditName.text.toString().isEmpty()){
                Toast.makeText(this,"Enter a name",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,
                    " Begining quiz for ${txtEditName.text.toString()}",
                    Toast.LENGTH_SHORT).show()
                val intent=Intent(this,QuizQuestions::class.java)
                intent.putExtra(USERNAME,txtEditName.text.toString())
            startActivity(intent)
            finish()
            }

        }
    }
}