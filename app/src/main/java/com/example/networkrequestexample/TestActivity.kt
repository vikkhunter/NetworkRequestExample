package com.example.networkrequestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_menu)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        // Data source for the AutoCompleteTextView
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Create an ArrayAdapter for the AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)

        // Set the adapter to the AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter)

        // Optional: Handle item selection
        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            textInputLayout.helperText = "Selected: $selectedItem"
        }

    }
}