package com.example.szakdolgozat_ifjuzsolt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.szakdolgozat_ifjuzsolt.menuk.MenuLoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, MenuLoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}