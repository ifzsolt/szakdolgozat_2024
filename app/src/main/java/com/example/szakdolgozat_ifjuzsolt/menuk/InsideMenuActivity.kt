package com.example.szakdolgozat_ifjuzsolt.menuk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.szakdolgozat_ifjuzsolt.Constants
import com.example.szakdolgozat_ifjuzsolt.PontszamokActivity
import com.example.szakdolgozat_ifjuzsolt.R
import com.example.szakdolgozat_ifjuzsolt.orak.ElsoOraAlapokActivity
import com.example.szakdolgozat_ifjuzsolt.orak.HarmadikOraElagazasokActivity
import com.example.szakdolgozat_ifjuzsolt.orak.MasodikOraValtozokActivity
import com.example.szakdolgozat_ifjuzsolt.orak.NegyedikOraCiklusokActivity

class InsideMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_menu)
        val button1 =findViewById<Button>(R.id.buttonelso)
        val button2 =findViewById<Button>(R.id.buttonmasodik)
        val button3 =findViewById<Button>(R.id.buttonharmadik)
        val button4 =findViewById<Button>(R.id.buttonnegyedik)
        val buttonscoreboard = findViewById<Button>(R.id.ButtonScoreboard)
        val textViewUsername = findViewById<TextView>(R.id.textViewBelepett)
        val username = intent.getStringExtra("username")
        textViewUsername.text = "Szia $username!"

        button1.setOnClickListener{
            val intent = Intent(this, ElsoOraAlapokActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(this, MasodikOraValtozokActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent = Intent(this, HarmadikOraElagazasokActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }
        button4.setOnClickListener{
            val intent = Intent(this, NegyedikOraCiklusokActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }

        buttonscoreboard.setOnClickListener{
            val scoreboard = Intent(this, PontszamokActivity::class.java)
            scoreboard.putExtra(Constants.USER_NAME, username)
            startActivity(scoreboard)
        }
    }
}