package com.alex.gamermvvmapp.presentation.screens.singup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alex.gamermvvmapp.presentation.components.DefaultTopBar
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.singup.components.SignUpContent
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavHostController){
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Nuevo usuario",
                     upAvailable = true,
                     navController = navController
                 )
        },
        content = {
            SignUpContent()
        },
        bottomBar = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen(){
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignUpScreen(rememberNavController())
        }
    }
}