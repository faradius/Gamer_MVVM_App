package com.alex.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alex.gamermvvmapp.presentation.screens.home.HomeScreen
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.profile.ProfileScreen
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditScreen
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){

        authNavGraph(navController = navController)

        composable(route = RootScreen.Home.route){
            HomeScreen()
        }

        composable(route = AuthScreen.Profile.route){
            ProfileScreen(navController)
        }

        composable(
            route = AuthScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let{
                ProfileEditScreen(navController)
            }

        }
    }
}