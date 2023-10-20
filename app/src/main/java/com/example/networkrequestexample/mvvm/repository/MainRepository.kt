package com.example.networkrequestexample.mvvm.repository

import com.example.networkrequestexample.mvvm.network.APIResponse
import com.example.networkrequestexample.mvvm.network.ScoreAPI
import com.example.networkrequestexample.mvvm.network.ScoreResponse
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(val scoreAPI: ScoreAPI) {
    suspend fun getScore(): Response<ScoreResponse> {
        return scoreAPI.getScore()
    }
}


//accessToken