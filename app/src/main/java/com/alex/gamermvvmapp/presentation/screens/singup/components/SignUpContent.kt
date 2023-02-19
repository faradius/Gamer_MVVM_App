package com.alex.gamermvvmapp.presentation.screens.singup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.components.DefaultTextField
import com.alex.gamermvvmapp.presentation.screens.login.LoginScreen
import com.alex.gamermvvmapp.presentation.screens.login.LoginViewModel
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpScreen
import com.alex.gamermvvmapp.presentation.screens.singup.SignUpViewModel
import com.alex.gamermvvmapp.presentation.ui.theme.DarkGray500
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alex.gamermvvmapp.presentation.ui.theme.Red500

@Composable
fun SignUpContent(viewModel: SignUpViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            //.padding()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Red500)
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    modifier = Modifier.height(110.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Imagen de usuario"
                )
            }

        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 160.dp),
            backgroundColor = DarkGray500
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 40.dp),
                    text = "REGISTRO",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Por favor ingresa estos datos para continuar",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = viewModel.username.value,
                    onValueChange = { viewModel.username.value = it},
                    label = "Nombre de Usuario",
                    icon = Icons.Default.Person,
                    errorMsg = viewModel.usernameErrorMsg.value,
                    validateField = {
                        viewModel.validateUsername()
                    }
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it},
                    label = "Correo Electrónico",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrorMsg.value,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it},
                    label = "Contraseña",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    errorMsg = viewModel.passwordErrorMsg.value,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.confirmPassword.value,
                    onValueChange = { viewModel.confirmPassword.value = it},
                    label = "Confirmar Contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    errorMsg = viewModel.confirmPasswordErrorMsg.value,
                    validateField = {
                        viewModel.validateConfirmPassword()
                    }
                )

                DefaultButtom(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 25.dp),
                    text = "REGISTRARSE",
                    onClick = {  },
                    enabled = viewModel.isEnabledSignUpButton
                )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpContent() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignUpContent()
        }
    }
}