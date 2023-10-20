package com.example.networkrequestexample.mvvm.network

sealed class APIResponse<out T> {
    data class OnSuccess<out T>(val data: T) : APIResponse<T>()
    data class OnError(val error: String) : APIResponse<Nothing>()
    class OnLoading: APIResponse<Nothing>()
}
