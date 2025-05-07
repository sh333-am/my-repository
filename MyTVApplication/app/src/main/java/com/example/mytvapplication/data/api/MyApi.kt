package com.example.mytvapplication.data.api

import com.example.mytvapplication.data.Weathermodel
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("v1/current.json")
    suspend fun get(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<Weathermodel>


}


