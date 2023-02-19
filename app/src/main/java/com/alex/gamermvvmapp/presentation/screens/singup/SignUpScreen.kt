package com.alex.gamermvvmapp.presentation.screens.singup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(){
    Scaffold(
        topBar = {},
        content = {
            Text(text = "SingUpScreen")
        },
        bottomBar = { }
    )
}