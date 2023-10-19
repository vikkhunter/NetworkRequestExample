package com.example.networkrequestexample.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.networkrequestexample.sqlite.Constants.DATABASE_NAME

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    // implementation of this method will be provided by room
    abstract fun employeeDao(): EmployeeDao

    companion object {

        @Volatile
        private var database: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase? {
            return database ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, EmployeeDatabase::class.java, DATABASE_NAME)
                        .build()
                database = instance
                database
            }
        }

    }

}