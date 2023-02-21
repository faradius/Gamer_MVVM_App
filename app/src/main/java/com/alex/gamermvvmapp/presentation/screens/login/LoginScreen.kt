package com.alex.gamermvvmapp.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alex.gamermvvmapp.presentation.screens.login.components.LoginBottomBar
import com.alex.gamermvvmapp.presentation.screens.login.components.LoginContent
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

//En el screen no se colocan los componentes de forma directa
@Composable
fun LoginScreen(navController: NavHostController) {

    //Es recomendable tener este componente como primera instancia o el componente principal Scaffold y no una columna (Column)
    //Scaffold es como el cordinator layout
    Scaffold(
        topBar = {},
        content = {
            LoginContent(it, navController)
        },
        bottomBar = {
            LoginBottomBar(navController)
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}