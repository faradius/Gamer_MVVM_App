package com.alex.gamermvvmapp.presentation.screens.singup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrorMsg: MutableState<String> = mutableStateOf("")

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMsg: MutableState<String> = mutableStateOf("")

    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrorMsg: MutableState<String> = mutableStateOf("")

    var isEnabledSignUpButton = false

    fun enabledSignUpButton() {
        //Esto va hacer true mientras el email y la password sean true
        isEnabledSignUpButton =
            isUsernameValid.value && isEmailValid.value && isPasswordValid.value && isConfirmPasswordValid.value
    }

    fun validateUsername() {
        if (username.value.length >= 3) {
            isUsernameValid.value = true
            usernameErrorMsg.value = ""
        } else {
            isUsernameValid.value = false
            usernameErrorMsg.value = "Al menos 5 caracteres"
        }

        enabledSignUpButton()
    }

    fun validateEmail() {
        //Este es un metodo verifica si es un email valido
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMsg.value = "El email no es valido"
        }

        //Una vez que termine de validar mandamos a llamar el metodo
        enabledSignUpButton()
    }

    fun validatePassword() {

        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrorMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrorMsg.value = "Al menos 6 caracteres"
        }

        enabledSignUpButton()
    }

    fun validateConfirmPassword() {
        if (password.value == confirmPassword.value) {
            isConfirmPasswordValid.value = true
            confirmPasswordErrorMsg.value = ""
        } else {
            isConfirmPasswordValid.value = false
            confirmPasswordErrorMsg.value = "Las Contraseñas no coinciden"
        }

        enabledSignUpButton()
    }


}