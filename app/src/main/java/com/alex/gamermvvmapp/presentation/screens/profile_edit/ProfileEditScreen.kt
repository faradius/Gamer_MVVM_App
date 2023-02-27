package com.alex.gamermvvmapp.presentation.screens.profile_edit

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.components.DefaultTopBar
import com.alex.gamermvvmapp.presentation.screens.profile_edit.components.ProfileEditContent
import com.alex.gamermvvmapp.presentation.screens.singup.components.SignUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user: String
){
    Log.d("ProfileScreen", "Usuario: $user")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            ProfileEditContent(navController)
        },
        bottomBar = { }
    )
}