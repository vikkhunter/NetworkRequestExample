package com.example.networkrequestexample.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.networkrequestexample.R
import com.example.networkrequestexample.databinding.ActivityMvvmexampleBinding
import com.example.networkrequestexample.mvvm.network.APIResponse
import com.example.networkrequestexample.mvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMExample : AppCompatActivity() {

    lateinit var binding: ActivityMvvmexampleBinding
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmexample)

        viewModel.scoreLiveData.observe(this) { response ->
            when (response) {
                is APIResponse.OnSuccess -> {
                    //log
                    Log.d("TAG", "OnSuccess: ${response.data}")
                }

                is APIResponse.OnError -> {
                    //log
                    Log.d("TAG", "OnError: ${response.error}")
                }

                is APIResponse.OnLoading -> {
                    //
                }

                else -> {}
            }
        }

        binding.apply {
            tvData.setOnClickListener {
                viewModel.getScores()
            }
        }
    }
}