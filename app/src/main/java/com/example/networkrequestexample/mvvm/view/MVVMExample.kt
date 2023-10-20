package com.example.networkrequestexample.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.networkrequestexample.R
import com.example.networkrequestexample.databinding.ActivityMvvmexampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMExample : AppCompatActivity() {

    lateinit var binding: ActivityMvvmexampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmexample)
        binding.apply {
            tvData.setOnClickListener {
                Log.d("TAG", "onCreate: ")
            }
        }
    }
}