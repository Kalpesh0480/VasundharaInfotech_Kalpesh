package com.example.vasundharainfotech.viewmodel


import com.example.vasundharainfotech.retrofit.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getAllData() = apiHelper.getAllData()
}