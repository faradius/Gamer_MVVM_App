package com.alex.gamermvvmapp.presentation.navigation.routes

sealed class DetailsScreen(val route: String){

    object ProfileUpdate: DetailsScreen("profile/edit/{user}"){
        fun passUser(user: String) = "profile/edit/$user"
    }
}