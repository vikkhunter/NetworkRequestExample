package com.example.networkrequestexample.room_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admin_employee")
data class Employee(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val department: String,
    val designation: String
)
//Entity -> Model classes , are used for creating tables
//DAO -> used for accessing data from DB
//Database Class ->

//everything is done at compile time
//purely annotation based, boiler plate code is removed
//live data for real time access
