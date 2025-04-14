package com.example.myapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class BookViewModel() : ViewModel() {


        private val _postList = mutableStateOf<List<Post>>(emptyList())
        val postList: State<List<Post>> = _postList

        private val _isLoading = mutableStateOf(false)
        val isLoading: State<Boolean> = _isLoading

        fun getPosts() {
            viewModelScope.launch {
                _isLoading.value = true
                try {
                    val response = RetrofitInstance.api.getPosts()
                    if (response.isSuccessful) {
                        _postList.value = response.body() ?: emptyList()
                    }
                } catch (e: Exception) {
                    _postList.value = emptyList()
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }




