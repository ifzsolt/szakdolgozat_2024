package com.example.szakdolgozat_ifjuzsolt.belepes

import com.example.szakdolgozat_ifjuzsolt.database.DatabaseHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.szakdolgozat_ifjuzsolt.menuk.InsideMenuActivity
import com.example.szakdolgozat_ifjuzsolt.R
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val dbHelper = DatabaseHelper(this)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val username = findViewById<EditText>(R.id.editTextLoginUsername)
        val password = findViewById<EditText>(R.id.editTextLoginPassword)

        buttonLogin.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()

            if (usernameText.isNotEmpty() && passwordText.isNotEmpty()) {
                val db = dbHelper.readableDatabase
                val projection = arrayOf(DatabaseContract.UserEntry.COLUMN_USERNAME, DatabaseContract.UserEntry.COLUMN_PASSWORD)
                val selection = "${DatabaseContract.UserEntry.COLUMN_USERNAME} = ? AND ${DatabaseContract.UserEntry.COLUMN_PASSWORD} = ?"
                val selectionArgs = arrayOf(usernameText, passwordText)
                val cursor = db.query(
                    DatabaseContract.UserEntry.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
                )
                if (cursor != null && cursor.count > 0) {
                    Toast.makeText(applicationContext, "Sikeres belépés!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, InsideMenuActivity::class.java)
                    intent.putExtra("username", usernameText)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Hibás felhasználónév vagy jelszó!", Toast.LENGTH_SHORT).show()
                }
                cursor?.close()
            } else {
                Toast.makeText(applicationContext, "Kérem minden mezőt töltsön ki!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}