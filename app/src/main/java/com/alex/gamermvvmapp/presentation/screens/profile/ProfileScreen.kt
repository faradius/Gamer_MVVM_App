package com.alex.gamermvvmapp.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.navigation.AppScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {},
        content = {
                 DefaultButtom(
                     modifier = Modifier,
                     text = "Cerrar Sesión",
                     onClick = {
                         viewModel.logout()
                         navController.navigate(route = AppScreen.Login.route){
                             popUpTo(AppScreen.Profile.route){ inclusive = true }
                         }
                     })
        },
        bottomBar = {}
    )
}