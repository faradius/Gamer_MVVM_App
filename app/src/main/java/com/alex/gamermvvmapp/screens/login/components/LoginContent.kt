package com.alex.gamermvvmapp.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.screens.login.LoginScreen
import com.alex.gamermvvmapp.ui.theme.GamerMVVMAppTheme

@Composable
fun LoginContent(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(130.dp),
            painter = painterResource(id = R.drawable.control),
            contentDescription = "Control de xbox 360"
        )
        Text(
            text = "FIREBASE MVVM"
        )
        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "LOGIN"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Por favor inicia sesión para continuar"
        )
        TextField(
            modifier = Modifier.padding(top = 25.dp),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Correo electronico")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Contraseña")
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 15.dp),
            onClick = { }
        ) {
            Text(text = "INICIAR SESIÓN")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContent() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen()
        }
    }
}