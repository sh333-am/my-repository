package com.example.myapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.datalayer.model.Post
import com.example.myapp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.myapp.datalayer.remote.ApiService
import com.example.myapp.domain.repository.Usecase

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val getUseCase: Usecase) : ViewModel() {


        private val _postList = mutableStateOf<List<Post>>(emptyList())
        val postList: State<List<Post>> = _postList

        private val _isLoading = mutableStateOf(false)
        val isLoading: State<Boolean> = _isLoading

        fun getPosts() {
            viewModelScope.launch {
                _isLoading.value = true
                try {
                    val response = getUseCase()
                    _postList.value = response
                } catch (e: Exception) {
                    _postList.value = emptyList()
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }




