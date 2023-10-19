package com.example.networkrequestexample.room_db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {

    val employeesList: LiveData<List<Employee>>?
    var db: EmployeeDatabase? = null

    init {
        employeesList = EmployeeDatabase.getInstance(application)?.employeeDao()?.getAllEmployees()
        db = EmployeeDatabase.getInstance(application)
    }

    fun insertData(
        name: String,
        department: String,
        designation: String,
    ) {
        viewModelScope.launch {
            db?.employeeDao()
                ?.insert(
                    Employee(
                        name = name,
                        department = department,
                        designation = designation
                    )
                )
        }
    }

}