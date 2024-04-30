package com.example.szakdolgozat_ifjuzsolt.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract.UserEntry.COLUMN_POINTS
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract.UserEntry.COLUMN_USERNAME
import com.example.szakdolgozat_ifjuzsolt.database.DatabaseContract.UserEntry.TABLE_NAME

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DatabaseContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DatabaseContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    fun updatePoints(username: String, newPoints: Int) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_POINTS, newPoints)
        }
        val selection = "$COLUMN_USERNAME = ?"
        val selectionArgs = arrayOf(username)
        db.update(TABLE_NAME, values, selection, selectionArgs)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "User.db"
    }
}
