package com.alex.gamermvvmapp.presentation.screens.singup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.alex.gamermvvmapp.domain.use_cases.users.UsersUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val usersUseCases: UsersUseCases
) : ViewModel() {

    //STATE FORM
    var state by mutableStateOf(SignupState())
        private set

    var isUsernameValid: Boolean by mutableStateOf(false)
        private set
    var usernameErrorMsg: String by mutableStateOf("")
        private set

    var isEmailValid: Boolean by mutableStateOf(false)
        private set
    var emailErrorMsg: String by mutableStateOf("")
        private set

    var isPasswordValid: Boolean by mutableStateOf(false)
        private set
    var passwordErrorMsg: String by mutableStateOf("")
        private set

    var isConfirmPasswordValid: Boolean by mutableStateOf(false)
        private set
    var confirmPasswordErrorMsg: String by mutableStateOf("")
        private set

    var isEnabledSignUpButton = false

    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    var user = User()

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun onSignup() {
        user.username = state.username
        user.email = state.email
        user.password = state.password

        signup(user)
    }

    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        usersUseCases.create(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCases.signUp(user)
        signupResponse = result
    }

    fun enabledSignUpButton() {
        //Esto va hacer true mientras el email y la password sean true
        isEnabledSignUpButton =
            isUsernameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid
    }

    fun validateUsername() {
        if (state.username.length >= 3) {
            isUsernameValid = true
            usernameErrorMsg = ""
        } else {
            isUsernameValid = false
            usernameErrorMsg = "Al menos 5 caracteres"
        }

        enabledSignUpButton()
    }

    fun validateEmail() {
        //Este es un metodo verifica si es un email valido
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrorMsg = ""
        } else {
            isEmailValid = false
            emailErrorMsg = "El email no es valido"
        }

        //Una vez que termine de validar mandamos a llamar el metodo
        enabledSignUpButton()
    }

    fun validatePassword() {

        if (state.password.length >= 6) {
            isPasswordValid = true
            passwordErrorMsg = ""
        } else {
            isPasswordValid = false
            passwordErrorMsg = "Al menos 6 caracteres"
        }

        enabledSignUpButton()
    }

    fun validateConfirmPassword() {
        if (state.password == state.confirmPassword) {
            isConfirmPasswordValid = true
            confirmPasswordErrorMsg = ""
        } else {
            isConfirmPasswordValid = false
            confirmPasswordErrorMsg = "Las Contraseñas no coinciden"
        }

        enabledSignUpButton()
    }


}