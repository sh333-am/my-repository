package com.example.myapp.domain.repository

import com.example.myapp.datalayer.model.Post

interface UserRepository {
    suspend fun getposts() : List<Post>
}