package com.example.myapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items



@Composable
fun AppUI(viewModel: BookViewModel = viewModel()) {
        val posts by viewModel.postList
        val isLoading by viewModel.isLoading

        Box(
                modifier = Modifier
                        .fillMaxSize() // Ensures the Box takes full screen
                        .padding(16.dp),
                contentAlignment = Alignment.Center // Centers content inside
        ) {
                Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                        Button(onClick = { viewModel.getPosts() }) {
                                Text("Fetch Posts")
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        if (isLoading) {
                                Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                ) {
                                        CircularProgressIndicator()
                                }
                        } else {
                                LazyColumn {
                                        items(posts) { post ->
                                                PostItem(post)
                                        }
                                }
                        }
                }
        }
}


@Composable
fun PostItem(post: Post) {
        Card(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
                Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                                text = post.title,
                                style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
                }
        }
}












