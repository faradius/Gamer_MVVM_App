package com.alex.gamermvvmapp.presentation.screens.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")


}