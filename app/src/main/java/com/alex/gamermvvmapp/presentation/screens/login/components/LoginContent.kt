package com.alex.gamermvvmapp.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.components.DefaultTextField
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.ui.theme.DarkGray500
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alex.gamermvvmapp.presentation.ui.theme.Red500

@Composable
fun LoginContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
    ) {
        BoxHeader()
        CardForm()
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Red500)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier.height(130.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Control de xbox 360"
            )
        }

    }
}

@Composable
fun CardForm() {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
        backgroundColor = DarkGray500
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = "LOGIN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Por favor inicia sesión para continuar",
                fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = email,
                onValueChange = { email = it},
                label = "Correo Electrónico",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )

            DefaultTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = password,
                onValueChange = { password = it},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true
            )

            DefaultButtom(
                text = "INICIAR SESIÓN",
                onClick = {  }
            )
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
            LoginScreen(rememberNavController())
        }
    }
}