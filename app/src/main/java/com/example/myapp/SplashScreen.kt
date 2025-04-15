package com.example.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController : NavHostController){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("AppLogin") {
            popUpTo("SplashScreen") {inclusive = true } // Remove splash from back stack
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), 
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display Image
            Image(
                painter = painterResource(id = R.drawable.jio), 
                contentDescription = "App Logo",
                modifier = Modifier.size(150.dp) 
            )

            Spacer(modifier = Modifier.height(16.dp)) 


            Text(
                text = "Welcome to My App",
                style = TextStyle(color = Color.Black, fontSize = 24.sp)
            )
        }
    }
}
