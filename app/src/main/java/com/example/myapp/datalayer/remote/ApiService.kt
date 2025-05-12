package com.example.myapp.datalayer.remote

import com.example.myapp.datalayer.model.Post
import retrofit2.http.GET

interface ApiService {

        @GET("posts")
        suspend fun getPosts(): List<Post>



    }


