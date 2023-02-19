package com.alex.gamermvvmapp.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false
    fun enabledLoginButton(){
        //Esto va hacer true mientras el email y la password sean true
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }

    fun validateEmail(){
        //Este es un metodo verifica si es un email valido
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value = true
            emailErrorMsg.value = ""
        }
        else{
            isEmailValid.value = false
            emailErrorMsg.value = "El email no es valido"
        }

        //Una vez que termine de validar mandamos a llamar el metodo
        enabledLoginButton()
    }

    fun validatePassword(){

        if (password.value.length >= 6){
            isPasswordValid.value = true
            passwordErrorMsg.value = ""
        }
        else{
            isPasswordValid.value = false
            passwordErrorMsg.value = "Al menos 6 caracteres"
        }

        enabledLoginButton()
    }
}