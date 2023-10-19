package com.example.networkrequestexample.android_basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkrequestexample.R

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.lv_names)
        val adapter = ActressAdapter(getActressDummyData())
        recyclerView.adapter = adapter

    }

    private fun getDummyData(): List<Student> {
        return arrayListOf(
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
    }

    private fun getActressDummyData(): List<Actress> {
        return arrayListOf(
            Actress("Actress1", R.drawable.ic_actress_1),
            Actress("Actress2", R.drawable.ic_actress_2),
            Actress("Actress3", R.drawable.ic_actress_3),
            Actress("Actress4", R.drawable.ic_actress_4),
            Actress("Actress5", R.drawable.ic_actress_5),
            Actress("Actress6", R.drawable.ic_actress_6),
            Actress("Actress1", R.drawable.ic_actress_1),
            Actress("Actress2", R.drawable.ic_actress_2),
            Actress("Actress3", R.drawable.ic_actress_3),
            Actress("Actress4", R.drawable.ic_actress_4),
            Actress("Actress5", R.drawable.ic_actress_5),
            Actress("Actress6", R.drawable.ic_actress_6),
            Actress("Actress1", R.drawable.ic_actress_1),
            Actress("Actress2", R.drawable.ic_actress_2),
            Actress("Actress3", R.drawable.ic_actress_3),
            Actress("Actress4", R.drawable.ic_actress_4),
            Actress("Actress5", R.drawable.ic_actress_5),
            Actress("Actress6", R.drawable.ic_actress_6),
        )
    }

    private fun listViewWithCustomAdapter() {
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