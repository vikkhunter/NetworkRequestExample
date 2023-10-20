package com.example.networkrequestexample.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkrequestexample.mvvm.network.APIResponse
import com.example.networkrequestexample.mvvm.network.ScoreResponse
import com.example.networkrequestexample.mvvm.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {

    //flows and livedata

    private val _scoresMutableLiveData = MutableLiveData<APIResponse<ScoreResponse?>?>()
    val scoreLiveData: LiveData<APIResponse<ScoreResponse?>?> = _scoresMutableLiveData

    fun getScores() {
        //401, 403, 404, 405, 500 HTTP Response code
        viewModelScope.launch {
            _scoresMutableLiveData.postValue(APIResponse.OnLoading())
            val response = repository.getScore()
            if (response.isSuccessful) { //200, response.code() //HTTP Response code
                _scoresMutableLiveData.postValue(APIResponse.OnSuccess(response.body()))
            } else {
                if(response.code() == 401) {
                    createNewToken()
                }
                _scoresMutableLiveData.postValue(APIResponse.OnError(response.message()))
            }
        }
    }

    fun createNewToken() {

    }

    //accessToken
    //expire 5 mins
    //401
    //createNewToken -> accessToken
}