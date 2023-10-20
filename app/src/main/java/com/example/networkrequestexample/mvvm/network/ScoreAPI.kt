package com.example.networkrequestexample.mvvm.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ScoreAPI {
    @GET("score")
    suspend fun getScore(): Response<ScoreResponse>

    @GET("score")
    suspend fun getLiveScore(): Response<ScoreResponse>

    @GET("score")
    suspend fun getHighScore(): Response<ScoreResponse>

    @GET("score")
    suspend fun createNewToken(): Response<ScoreResponse>

}