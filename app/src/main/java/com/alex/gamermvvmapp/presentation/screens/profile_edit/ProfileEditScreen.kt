package com.alex.gamermvvmapp.presentation.screens.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.components.DefaultTopBar
import com.alex.gamermvvmapp.presentation.screens.profile_edit.components.ProfileEditContent
import com.alex.gamermvvmapp.presentation.screens.singup.components.SignUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navController: NavHostController){
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