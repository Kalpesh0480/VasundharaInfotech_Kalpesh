package com.example.vasundharainfotech.retrofit

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
    suspend fun getAllData() = apiService.getAllData()
}