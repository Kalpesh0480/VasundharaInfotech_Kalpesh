package com.example.vasundharainfotech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vasundharainfotech.model.ComputerDetails
import com.example.vasundharainfotech.retrofit.ApiHelper
import com.example.vasundharainfotech.retrofit.RetrofitBuilder
import com.example.vasundharainfotech.utility.Status
import com.example.vasundharainfotech.viewmodel.MainViewModel
import com.example.vasundharainfotech.viewmodel.ViewModelFactory
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel();
        setupObservers();

    }

    private fun setupViewModel() {
        val viewModelFactory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private  fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { users -> retrieveData(users)
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }
    private fun retrieveData(getData: Response<ComputerDetails>) {
        val  strIP=getData.body()!!.ip;
        val  strCity=getData.body()!!.city;
        val  country_name=getData.body()!!.countryName;
        Log.e("getData" , strIP +" ::" + strCity)

    }



}