package com.alex.gamermvvmapp.presentation.screens.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.presentation.components.ProgressBar
import com.alex.gamermvvmapp.presentation.navigation.graphs.Graph
import com.alex.gamermvvmapp.presentation.screens.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){
    when(val loginResponse = viewModel.loginResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            //Esta corrutina es necesario por que se esta evaluando un estado en el loginFlow(loading, succes, failure),
            //si se hace directo puede que el estado cambie y eso afectaria la navegación
            LaunchedEffect(Unit){
                navController.navigate(route = Graph.HOME){
                    //Permite borrar el historial de pantallas
                    popUpTo(Graph.AUTHENTICATION){
                        inclusive = true
                    }
                }
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, loginResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> Log.d("LoginContent", "Error: Error desconocido")
    }
}