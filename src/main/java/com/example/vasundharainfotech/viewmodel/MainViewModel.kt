package com.example.vasundharainfotech.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.vasundharainfotech.model.ComputerDetails
import com.example.vasundharainfotech.utility.Resource


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _computerDetails: MutableLiveData<Response<ComputerDetails>> = MutableLiveData()
    val getComputerDetails: LiveData<Response<ComputerDetails>> = _computerDetails

    init {
        fetchDataComputerDetails()
    }

    fun fetchDataComputerDetails() {
        viewModelScope.launch {
            try {
                val  getData = mainRepository.getUsers()
                _computerDetails.value = getData
            } catch (e: Exception) {

                Log.e("Toast",e.message.toString())
                // Handle error
            }
        }
    }

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    // get all  Data

    fun getAllData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getAllData()))

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}