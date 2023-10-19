package com.example.networkrequestexample.room_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.networkrequestexample.R

class RoobDBExample : AppCompatActivity() {

    private lateinit var viewModel: EmployeeViewModel
    val employees = ArrayList<Employee>()
    var adapter = EmployeeAdapter(employees)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roob_dbexample)
        viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)

        val etName = findViewById<EditText>(R.id.et_name)
        val etDepartment = findViewById<EditText>(R.id.et_department)
        val etDesignation = findViewById<EditText>(R.id.et_designation)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            viewModel.insertData(
                etName.text.toString(),
                etDepartment.text.toString(),
                etDesignation.text.toString(),
            )
        }

        setUpList()


        viewModel.employeesList?.observe(this
        ) { list->
           adapter.update(list)
        }

    }

    private fun setUpList() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_employees)
        recyclerView.adapter = adapter
    }


}