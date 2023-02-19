package com.alex.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ){
        composable(route = AppScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route = AppScreen.SignUp.route){
            SignUpScreen()
        }
    }
}