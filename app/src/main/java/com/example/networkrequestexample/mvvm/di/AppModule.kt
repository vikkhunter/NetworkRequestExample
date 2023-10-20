package com.example.networkrequestexample.mvvm.di

import android.content.Context
import com.example.networkrequestexample.mvvm.network.RetrofitClient
import com.example.networkrequestexample.mvvm.network.ScoreAPI
import com.example.networkrequestexample.mvvm.repository.MainRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(scoreAPI: ScoreAPI): MainRepository {
        return MainRepository(scoreAPI)
    }

    @Provides
    @Singleton
    fun provideAPI(): ScoreAPI {
        return RetrofitClient.retrofit.create(ScoreAPI::class.java)
    }

}