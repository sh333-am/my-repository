package com.example.myapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val viewModel: BookViewModel = viewModel()
    NavHost(navController = navController, startDestination = "SplashScreen", builder = {
        composable("SplashScreen") {
            SplashScreen(navController)
        }
        composable("AppLogin") {
            AppLogin(navController)
        }
        composable("AppUI") {
            AppUI(viewModel)
        }
    }

        )
    }
