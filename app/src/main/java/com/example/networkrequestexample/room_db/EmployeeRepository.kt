package com.example.networkrequestexample.room_db

//source for data
class EmployeeRepository(val db: EmployeeDatabase) {
    suspend fun insert(employee: Employee) {
        db.employeeDao().insert(employee)
    }
}