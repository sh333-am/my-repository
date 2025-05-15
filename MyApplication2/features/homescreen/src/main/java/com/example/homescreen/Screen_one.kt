package com.example.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.FlowPreview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen_one(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Now In Android",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            BottomRow()
        }

    )
    {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxHeight()) {
                Text(
                    text = "What are you Interested In",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "Updates from topic you follow will appear here,Follow some things to get started",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 24.dp, end = 24.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    )
                Button(
                    onClick = {},
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp))
                {
                    Text(text = "Done")
                }
            }
        }
    }
}

@Composable
fun BottomRow(){
    Row (modifier = Modifier.fillMaxWidth()){
        IconButton(onClick = { /* Search */ }) {
            Icon(Icons.Default.Info, contentDescription = "Search")
        }
        IconButton(onClick = { /* Search */ }) {
            Icon(Icons.Default.Favorite, contentDescription = "Search")
        }
        IconButton(onClick = { /* Search */ }) {
            Icon(Icons.Default.Menu, contentDescription = "Search")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewScreen(){
    Screen_one()
}


