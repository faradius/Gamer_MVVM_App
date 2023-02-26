package com.alex.gamermvvmapp.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases):ViewModel() {
    //State Form
    var state by mutableStateOf(LoginState())
    private set //ponemos esto para no poder cambiar su valor desde otras clases

    var isEmailValid:Boolean by mutableStateOf(false)
    var emailErrorMsg:String by mutableStateOf("")


    var isPasswordValid:Boolean by mutableStateOf(false)
    var passwordErrorMsg:String by mutableStateOf("")

    //ENABLE BUTTON
    var isEnabledLoginButton = false

    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    val currentUser = authUseCases.getCurrentUser()
    init {
        if (currentUser != null){ //Si es diferente de null la sesión esta iniciada
            loginResponse = Response.Success(currentUser)
        }
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCases.login(state.email, state.password)
        loginResponse = result
    }
    fun enabledLoginButton(){
        //Esto va hacer true mientras el email y la password sean true
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }

    fun validateEmail(){
        //Este es un metodo verifica si es un email valido
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid = true
            emailErrorMsg = ""
        }
        else{
            isEmailValid = false
            emailErrorMsg = "El email no es valido"
        }

        //Una vez que termine de validar mandamos a llamar el metodo
        enabledLoginButton()
    }

    fun validatePassword(){

        if (state.password.length >= 6){
            isPasswordValid = true
            passwordErrorMsg = ""
        }
        else{
            isPasswordValid = false
            passwordErrorMsg = "Al menos 6 caracteres"
        }

        enabledLoginButton()
    }
}