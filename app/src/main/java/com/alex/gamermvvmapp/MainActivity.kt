package com.alex.gamermvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.gamermvvmapp.ui.theme.GamerMVVMAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerMVVMAppTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   BodyContent()
                }
            }
        }
    }
}

@Composable
fun BodyContent(){
    Column(
        modifier = Modifier
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

        Row() {
            Text(
                text = "No tienes cuenta?",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = "REGISTRATE AQUI",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BodyContent()
        }
    }
}