package com.example.vasundharainfotech


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vasundharainfotech.adapter.Adapter
import com.example.vasundharainfotech.blink_box.BlinkBoxActivity
import com.example.vasundharainfotech.model.GetDataDetails
import com.example.vasundharainfotech.model.SubCategoryModel
import com.example.vasundharainfotech.retrofit.ApiHelper
import com.example.vasundharainfotech.retrofit.RetrofitBuilder
import com.example.vasundharainfotech.utility.Status
import com.example.vasundharainfotech.viewmodel.MainViewModel
import com.example.vasundharainfotech.viewmodel.ViewModelFactory


class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var rv:RecyclerView
    private lateinit var btnFunctionality:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setOnClickList()
        setupViewModel()
        setupObservers()

    }
    private fun initView() {
         rv = findViewById<RecyclerView>(R.id.rv)
        btnFunctionality = findViewById<Button>(R.id.btnFunctionality)
    }

    private fun setOnClickList() {
        btnFunctionality.setOnClickListener {
            val intent = Intent(this, BlinkBoxActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setupViewModel() {
        val viewModelFactory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private  fun setupObservers() {
        // getData from Api
        viewModel.getAllData().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { data ->
                            val  message=it.data!!.body()!!.message
                            retrieveData(it.data.body()!!.data, it.data.body()!!.appCenter)
                            //retrieveData(it.data)
                            Log.e("getData" , message +" ::" + message)

                        }
                    }
                    Status.ERROR -> {
                        // Log.e("ERROR",it.message.toString())
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }

        })

    }


    var arraySubCategory=ArrayList<SubCategoryModel>()
    private fun retrieveData(data: List<GetDataDetails.Data>, arrayAppCenter: List<GetDataDetails.AppCenter>) {
        if(arrayAppCenter.size>0)
        {
            for( i in 0 until arrayAppCenter.size)
            {
                val  arrSubCategory=arrayAppCenter.get(i).subCategory
                for( j in 0 until arrSubCategory.size)
                {
                    arraySubCategory.add(SubCategoryModel(arrSubCategory.get(j).name,
                        arrSubCategory[j].icon,
                        arrSubCategory[j].star,
                        arrSubCategory[j].installedRange,
                        arrSubCategory[j].appLink,
                        ))
                }


            }
        }

        val adapter = Adapter(this, data,arraySubCategory)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = linearLayoutManager
        rv.adapter = adapter

    }
}