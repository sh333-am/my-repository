package com.example.myapp.domain.repository

import com.example.myapp.datalayer.model.Post
import com.example.myapp.domain.repository.UserRepository
import javax.inject.Inject

class Usecase @Inject constructor(private val repository: UserRepository){
    suspend operator fun invoke() : List<Post> = repository.getposts()

}