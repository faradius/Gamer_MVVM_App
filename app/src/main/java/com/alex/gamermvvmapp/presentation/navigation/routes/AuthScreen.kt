package com.alex.gamermvvmapp.presentation.navigation.routes

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object SignUp: AuthScreen("signup")
}
