package com.example.szakdolgozat_ifjuzsolt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseHelper
import com.example.szakdolgozat_ifjuzsolt.menuk.InsideMenuActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val btn_finish = findViewById<TextView>(R.id.btn_finish)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score.text = "Az elért pontszám:  $correctAnswer / $totalQuestions"
        btn_finish.setOnClickListener {
            val dbHelper = DatabaseHelper(this)
            val newPoints = correctAnswer
            dbHelper.updatePoints(username?:"", newPoints)
            val intent = Intent(this, InsideMenuActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}