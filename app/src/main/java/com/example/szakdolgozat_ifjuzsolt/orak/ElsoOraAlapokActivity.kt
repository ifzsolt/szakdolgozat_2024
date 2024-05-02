package com.example.szakdolgozat_ifjuzsolt.orak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.szakdolgozat_ifjuzsolt.Constants
import com.example.szakdolgozat_ifjuzsolt.R
import com.example.szakdolgozat_ifjuzsolt.menuk.InsideMenuActivity
import com.example.szakdolgozat_ifjuzsolt.tesztek.TesztActivity

class ElsoOraAlapokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elso_ora_alapok)
        val back = findViewById<Button>(R.id.buttonback)
        val test = findViewById<Button>(R.id.buttontest)
        val username = intent.getStringExtra(Constants.USER_NAME)
        back.setOnClickListener {
            val intent = Intent(this, InsideMenuActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        test.setOnClickListener {
            val intent = Intent(this, TesztActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }
    }
}