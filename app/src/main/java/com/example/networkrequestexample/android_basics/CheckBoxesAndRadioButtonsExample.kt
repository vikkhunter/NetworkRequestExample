package com.example.networkrequestexample.android_basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.networkrequestexample.R

class CheckBoxesAndRadioButtonsExample : AppCompatActivity() {

    private val TAG = "CheckBoxesAndRadioButto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_boxes_and_radio_buttons_example)

        val radioGroup = findViewById<RadioGroup>(R.id.rg_answers)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.d(TAG, "onCreate: ${group.findViewById<RadioButton>(checkedId).text}")
        }
    }
}