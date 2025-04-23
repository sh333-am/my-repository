package com.example.myapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.presentation.Screen.component.AppLogin
import com.example.myapp.presentation.Screen.component.AppUI
import com.example.myapp.presentation.Screen.component.SplashScreen
import com.example.myapp.presentation.viewmodel.BookViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun Navigation(){
    val navController = rememberNavController()
    val viewModel: BookViewModel = hiltViewModel()
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
