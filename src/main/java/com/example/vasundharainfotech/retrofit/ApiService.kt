package com.example.vasundharainfotech.retrofit

import com.example.vasundharainfotech.model.ComputerDetails
import com.example.vasundharainfotech.model.GetDataDetails
import retrofit2.Response


import retrofit2.http.GET

interface  ApiService {

    @GET("/json/")
    suspend fun getUsers(): Response<ComputerDetails>

    @GET("com.hd.camera.apps.high.quality")
    suspend fun getAllData() : Response<GetDataDetails>










}