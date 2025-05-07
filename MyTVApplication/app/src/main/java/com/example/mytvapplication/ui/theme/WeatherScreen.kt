package com.example.mytvapplication.ui.theme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mytvapplication.presentation.MyViewModel
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.example.mytvapplication.data.api.NetworkResponse


@Composable
fun Weatherpage(viewModel: MyViewModel){
    var city by remember {
        mutableStateOf("") }
    val weatherresult = viewModel._weatherResult.observeAsState()
    Row (modifier = Modifier.fillMaxWidth())
    {
        OutlinedTextField(value = city,
            onValueChange = {city = it},
            label = { Text(text = "Search for any location")},
            modifier = Modifier.weight(1f))
        IconButton(onClick = { viewModel.getdata(city)}) {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = null)
        }

    }

    when(val result = weatherresult.value){
        is NetworkResponse.Success->{
           Text(text = result.data.toString())
        }
        is NetworkResponse.Loading->{
            CircularProgressIndicator()
        }
        is NetworkResponse.Error->
        {
            Text(text = result.message)
        }

        null -> {
            Text(text = "No data available")
        }
    }

}