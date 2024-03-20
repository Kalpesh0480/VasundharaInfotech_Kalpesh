package com.example.vasundharainfotech.retrofit

import com.example.vasundharainfotech.model.ComputerDetails
import retrofit2.Response


import retrofit2.http.GET

interface  ApiService {

    @GET("/json/")
    suspend fun getUsers(): Response<ComputerDetails>

   // suspend fun getAllMovies() : Response<List<Movie>>






}