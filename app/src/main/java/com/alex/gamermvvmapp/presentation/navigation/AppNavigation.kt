package com.alex.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.profile.ProfileScreen
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditScreen
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
            SignUpScreen(navController)
        }

        composable(route = AppScreen.Profile.route){
            ProfileScreen(navController)
        }

        composable(
            route = AppScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let{
                ProfileEditScreen(navController, user = it)
            }

        }
    }
}