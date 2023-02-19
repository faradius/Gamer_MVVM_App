package com.alex.gamermvvmapp.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.screens.login.LoginScreen
import com.alex.gamermvvmapp.ui.theme.DarkGray500
import com.alex.gamermvvmapp.ui.theme.GamerMVVMAppTheme
import com.alex.gamermvvmapp.ui.theme.Red500

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
            OutlinedTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = "",
                onValueChange = { },
                label = {
                    Text(text = "Correo electronico")
                },
                leadingIcon = { //trailing es para poner el icono de lado derecho
                    Icon(//painter es para los recursos de android
                        imageVector = Icons.Default.Email,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = "",
                onValueChange = { },
                label = {
                    Text(text = "Contraseña")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 45.dp),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "INICIAR SESIÓN")
            }
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