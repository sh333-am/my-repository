package com.example.mytvapplication.data.api

interface MyApi {

    @GET("v1/current.json")
    suspend fun getApi(){

    }

}


