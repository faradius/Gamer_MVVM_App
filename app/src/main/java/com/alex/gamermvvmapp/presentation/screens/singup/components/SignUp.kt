package com.alex.gamermvvmapp.presentation.screens.singup.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.presentation.components.ProgressBar
import com.alex.gamermvvmapp.presentation.navigation.AuthScreen
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: SignUpViewModel = hiltViewModel()) {
    when(val signupResponse = viewModel.signupResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit){
                viewModel.createUser()
                navController.popBackStack(AuthScreen.Login.route, true)
                navController.navigate(route = AuthScreen.Profile.route)
            }
        }

        is Response.Failure -> {
            Toast.makeText(LocalContext.current, signupResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_SHORT).show()
        }

        else -> Log.d("SignUpContent", "SignUpContent Error: Error desconocido")
    }
}