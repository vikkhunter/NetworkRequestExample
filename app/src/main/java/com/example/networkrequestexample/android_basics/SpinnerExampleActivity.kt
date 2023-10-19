package com.example.networkrequestexample.android_basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.networkrequestexample.R

class SpinnerExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_example)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        val list = arrayListOf<String>("Item One", "Item Two", "Item three")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list)

        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->
                //do with selected item
                Log.d("position", "onCreate: $position")
            }
    }
}