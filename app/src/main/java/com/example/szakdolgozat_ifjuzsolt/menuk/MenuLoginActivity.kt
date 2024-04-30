package com.example.szakdolgozat_ifjuzsolt.menuk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.szakdolgozat_ifjuzsolt.R
import com.example.szakdolgozat_ifjuzsolt.belepes.LoginActivity
import com.example.szakdolgozat_ifjuzsolt.belepes.RegisterActivity

class MenuLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val facebook = findViewById<ImageView>(R.id.iv_facebook)
        val github = findViewById<ImageView>(R.id.iv_facebook)
        val instagram = findViewById<ImageView>(R.id.iv_instagram)

        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        facebook.setOnClickListener{
            val url = "https://www.facebook.com/zsolt.ifju.7/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        github.setOnClickListener{
            val url = "https://github.com/ifzsolt"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        instagram.setOnClickListener{
            val url = "https://www.instagram.com/jifjujolt/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}