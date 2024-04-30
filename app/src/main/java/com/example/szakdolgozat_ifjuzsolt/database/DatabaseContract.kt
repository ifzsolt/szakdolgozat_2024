package com.example.szakdolgozat_ifjuzsolt.database

import android.provider.BaseColumns

object DatabaseContract {
    object UserEntry : BaseColumns {
        const val TABLE_NAME = "user"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_POINTS = "points"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UserEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${UserEntry.COLUMN_USERNAME} TEXT," +
                "${UserEntry.COLUMN_EMAIL} TEXT," +
                "${UserEntry.COLUMN_PASSWORD} TEXT," +
                "${UserEntry.COLUMN_POINTS} INTEGER DEFAULT 0)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserEntry.TABLE_NAME}"
}
