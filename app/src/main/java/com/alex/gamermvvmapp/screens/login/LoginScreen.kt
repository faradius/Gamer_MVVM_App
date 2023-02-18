package com.alex.gamermvvmapp.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alex.gamermvvmapp.screens.login.components.LoginBottomBar
import com.alex.gamermvvmapp.screens.login.components.LoginContent
import com.alex.gamermvvmapp.ui.theme.GamerMVVMAppTheme

//En el screen no se colocan los componentes de forma directa
@Composable
fun LoginScreen() {
    //Es recomendable tener este componente como primera instancia o el componente principal Scaffold y no una columna (Column)
    //Scaffold es como el cordinator layout
    Scaffold(
        topBar = {},
        content = {
            LoginContent(it)
        },
        bottomBar = {
            LoginBottomBar()
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
            LoginScreen()
        }
    }
}