package com.example.networkrequestexample.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.networkrequestexample.sqlite.Constants.COLUMN_ADDRESS
import com.example.networkrequestexample.sqlite.Constants.COLUMN_AGE
import com.example.networkrequestexample.sqlite.Constants.COLUMN_ID
import com.example.networkrequestexample.sqlite.Constants.COLUMN_NAME
import com.example.networkrequestexample.sqlite.Constants.COLUMN_PROFESSION
import com.example.networkrequestexample.sqlite.Constants.DATABASE_NAME
import com.example.networkrequestexample.sqlite.Constants.DATABASE_VERSION
import com.example.networkrequestexample.sqlite.Constants.TABLE_NAME

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {


    private val TAG = "DatabaseHelper"
    override fun onCreate(db: SQLiteDatabase?) {
        //here the creation happens
        val tableQuery = """ 
            CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_NAME TEXT,
            $COLUMN_AGE INTEGER,
            $COLUMN_PROFESSION TEXT,
            $COLUMN_ADDRESS TEXT
        )
        """
        db?.execSQL(tableQuery)

        Log.d(TAG, "onCreate: ")
    }

    fun insertData(name: String, age: Int, profession: String, address: String = "London"): Long {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_AGE, age)
        contentValues.put(COLUMN_PROFESSION, profession)
        contentValues.put(COLUMN_ADDRESS, address)
        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun deleteData(id: Long): Int {
        val db = writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
    }

    fun retrieveData(id: Long): Cursor? {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID=?"
        return db.rawQuery(query, arrayOf(id.toString()))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d(TAG, "onUpgrade: ")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun update(id: Long, name: String?, age: Int, profession: String?): Int {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_AGE, age)
        contentValues.put(COLUMN_PROFESSION, profession)
        return db.update(TABLE_NAME, contentValues, "$COLUMN_ID=?", arrayOf(id.toString()))
    }
}