package com.example.szakdolgozat_ifjuzsolt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseHelper

class PontszamokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontszamok)
        val dbHelper = DatabaseHelper(this)
        val userList = findViewById<ListView>(R.id.userList)
        val users = mutableListOf<String>()
        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            DatabaseContract.UserEntry.COLUMN_USERNAME,
            DatabaseContract.UserEntry.COLUMN_EMAIL,
            DatabaseContract.UserEntry.COLUMN_POINTS
        )
        val cursor = db.query(
            DatabaseContract.UserEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor) {
            while (moveToNext()) {
                val username = getString(getColumnIndexOrThrow(DatabaseContract.UserEntry.COLUMN_USERNAME))
                val email = getString(getColumnIndexOrThrow(DatabaseContract.UserEntry.COLUMN_EMAIL))
                val points = getInt(getColumnIndexOrThrow(DatabaseContract.UserEntry.COLUMN_POINTS))
                val userString = "Név: $username, Email: $email, Pontok: $points"
                users.add(userString)
            }
        }
        cursor.close()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        userList.adapter = adapter
    }
}