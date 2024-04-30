package com.example.szakdolgozat_ifjuzsolt.belepes

import com.example.szakdolgozat_ifjuzsolt.database.DatabaseHelper
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.szakdolgozat_ifjuzsolt.R
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract

private fun checkIfUserExists(dbHelper: DatabaseHelper, username: String, email: String): Boolean {
    val db = dbHelper.readableDatabase
    val selection = "${DatabaseContract.UserEntry.COLUMN_USERNAME} = ? OR ${DatabaseContract.UserEntry.COLUMN_EMAIL} = ?"
    val selectionArgs = arrayOf(username, email)
    val cursor = db.query(
        DatabaseContract.UserEntry.TABLE_NAME,
        null,
        selection,
        selectionArgs,
        null,
        null,
        null
    )
    val userExists = cursor.count > 0
    cursor.close()
    return userExists
}

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var dbHelper = DatabaseHelper(this)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val username = findViewById<EditText>(R.id.editTextUsername)
        val email = findViewById<TextView>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        buttonRegister.setOnClickListener {
            val usernameText = username.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            if (usernameText.isNotEmpty() && emailText.isNotEmpty() && passwordText.isNotEmpty()) {
                if (checkIfUserExists(dbHelper, usernameText, emailText)) {
                    Toast.makeText(
                        applicationContext,
                        "Ez a felhasználónév vagy e-mail cím már használatban van!",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    val db = dbHelper.writableDatabase
                    val values = ContentValues().apply {
                        put(DatabaseContract.UserEntry.COLUMN_USERNAME, usernameText)
                        put(DatabaseContract.UserEntry.COLUMN_EMAIL, emailText)
                        put(DatabaseContract.UserEntry.COLUMN_PASSWORD, passwordText)
                        put(DatabaseContract.UserEntry.COLUMN_POINTS, 0)
                    }
                    val newRowId = db?.insert(DatabaseContract.UserEntry.TABLE_NAME, null, values)
                    if (newRowId != -1L) {
                        Toast.makeText(
                            applicationContext,
                            "Sikeres Regisztráció!",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Hiba a Regisztráció során!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(applicationContext, "Kérem minden mezőt töltsön ki!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}