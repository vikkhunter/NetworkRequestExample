package com.example.networkrequestexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener

class CheckBoxesAndRadioButtonsExample : AppCompatActivity() {

    private val TAG = "CheckBoxesAndRadioButto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_boxes_and_radio_buttons_example)

        val radioGroup = findViewById<RadioGroup>(R.id.rg_answers)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.d(TAG, "onCreate: ${group.findViewById<RadioButton>(checkedId).text}")
        }

        val checkboxOne = findViewById<CheckBox>(R.id.cb_first_selection)
        val checkboxTwo = findViewById<CheckBox>(R.id.cb_second_selection)
        val checkboxThree = findViewById<CheckBox>(R.id.cb_third_selection)

        val listOfCheckedItems = mutableListOf<String>()


        checkboxOne.setOnCheckedChangeListener { buttonView, isChecked ->
                 if(isChecked) {
                     listOfCheckedItems.add(buttonView.text.toString())
                 } else {
                     listOfCheckedItems.remove(buttonView.text.toString())
                 }

            Log.d(TAG, "onCreate: $listOfCheckedItems")
        }

        checkboxTwo.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                listOfCheckedItems.add(buttonView.text.toString())
            } else {
                listOfCheckedItems.remove(buttonView.text.toString())
            }
            Log.d(TAG, "onCreate: $listOfCheckedItems")
        }

        checkboxThree.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                listOfCheckedItems.add(buttonView.text.toString())
            } else {
                listOfCheckedItems.remove(buttonView.text.toString())
            }
            Log.d(TAG, "onCreate: $listOfCheckedItems")
        }


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.d(TAG, "onCreate: ${group.findViewById<RadioButton>(checkedId).text}")
        }

        callMeWheneverYouWant { number ->
            Log.d(TAG, "onCreate: $number")
        }

    }

    //High order function
    private fun callMeWheneverYouWant(callMeBack: (String) -> Unit) {
        val number = 10
        if(number % 2 == 0) {
            callMeBack(number.toString())
        }
    }

    private fun callMeWheneverYouWant() {

    }

}