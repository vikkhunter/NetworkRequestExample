package com.example.networkrequestexample.sqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.networkrequestexample.R
import com.example.networkrequestexample.sqlite.Constants.COLUMN_AGE
import com.example.networkrequestexample.sqlite.Constants.COLUMN_NAME
import com.example.networkrequestexample.sqlite.Constants.COLUMN_PROFESSION
import kotlin.random.Random

class SQliteExample : AppCompatActivity() {
    lateinit var db: DatabaseHelper

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_example)
        db = DatabaseHelper(this)

        findViewById<Button>(R.id.btn_create_db).setOnClickListener {
            val insertedRowId = db.insertData("Brett", Random.nextInt(50), "Doctor")
            if (insertedRowId != -1L) {
                Toast.makeText(this, "Inserted successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error while inserting data ", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn_delete_row).setOnClickListener {
            val deletedRow = db.deleteData(1)
            if (deletedRow != 0) {
                Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error while deleting data ", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn_update_row).setOnClickListener {
            val cursor = db.retrieveData(2)
            cursor?.use {
                while (cursor.moveToNext()) {
                    val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                    val age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE))
                    val profession = cursor.getString(cursor.getColumnIndex(COLUMN_PROFESSION))

                    Log.d("TAG", "onCreate: $name , $age, $profession")
                    val affectedRows = db.update(2 , name, age + 1, profession)
                    Log.d("TAG", "onCreate: $affectedRows")
                }
            }
        }

    }
}