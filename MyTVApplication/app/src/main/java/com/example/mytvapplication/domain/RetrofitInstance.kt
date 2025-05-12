package com.example.mytvapplication.domain

import com.example.mytvapplication.data.api.MyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance  {
    private const val baseurl = "";

    private fun get() : Retrofit{
        return Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val weatherapi : MyApi = get().create(MyApi::class.java)

}