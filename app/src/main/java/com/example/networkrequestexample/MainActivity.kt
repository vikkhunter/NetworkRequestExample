package com.example.networkrequestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.lv_names)
        val adapter = NamesAdapter(
            arrayListOf(
                Student(0L, "Josef", ""),
                Student(1L, "Rajesh", ""),
                Student(2L, "Brett", ""),
                Student(3L, "Vinay", ""),
                Student(4L, "Jyoti", ""),
                Student(5L, "Mister", ""),
                Student(0L, "Josef", ""),
                Student(1L, "Rajesh", ""),
                Student(2L, "Brett", ""),
                Student(3L, "Vinay", ""),
                Student(4L, "Jyoti", ""),
                Student(5L, "Mister", ""),
            )
        )
        listView.adapter = adapter
    }

    private fun populateListWithArrayAdapter(listView: ListView) {
        val listOfNames = arrayListOf<String>("Pawan", "Harsh", "Lucas")

        val adapter = ArrayAdapter<String>(this, R.layout.list_item, listOfNames)

        listView.adapter = adapter
    }
}