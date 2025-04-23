package com.example.myapp.datalayer.repositoryimp

import com.example.myapp.datalayer.remote.ApiService
import com.example.myapp.datalayer.model.Post
import com.example.myapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(private val apiService: ApiService) : UserRepository {

    override suspend fun getposts(): List<Post> {
        return apiService.getPosts()
    }
}
