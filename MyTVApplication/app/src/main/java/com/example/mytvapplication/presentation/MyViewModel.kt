package com.example.mytvapplication.presentation

import android.provider.SyncStateContract.Constants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytvapplication.data.Weathermodel
import com.example.mytvapplication.data.api.Constant
import com.example.mytvapplication.data.api.NetworkResponse
import com.example.mytvapplication.domain.RetrofitInstance
import com.example.mytvapplication.domain.RetrofitInstance.weatherapi
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class MyViewModel : ViewModel() {
    private val api = RetrofitInstance.weatherapi
    private val weatheresult = MutableLiveData<NetworkResponse<Weathermodel>>()
    val _weatherResult : LiveData<NetworkResponse<Weathermodel>> = weatheresult

    fun getdata(city:String){
        weatheresult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherapi.get(Constant.apikey, city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        weatheresult.value = NetworkResponse.Success(it)
                    }
                } else {
                    weatheresult.value = NetworkResponse.Error("failed")
                }
            }
                catch(e : Exception){
                    weatheresult.value = NetworkResponse.Error("failed")


                }


            }

        }
    }


