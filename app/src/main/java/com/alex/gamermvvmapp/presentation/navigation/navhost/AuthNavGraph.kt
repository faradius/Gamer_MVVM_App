package com.alex.gamermvvmapp.presentation.navigation.navhost

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.alex.gamermvvmapp.presentation.navigation.graphs.Graph
import com.alex.gamermvvmapp.presentation.navigation.routes.AuthScreen
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route = AuthScreen.SignUp.route){
            SignUpScreen(navController)
        }
    }
}