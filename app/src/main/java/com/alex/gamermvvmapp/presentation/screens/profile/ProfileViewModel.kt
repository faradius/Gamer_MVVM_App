package com.alex.gamermvvmapp.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.alex.gamermvvmapp.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val usersUseCases: UsersUseCases
) : ViewModel() {

    //Se vuelve solo lectura de datos, no permite modificar su valor desde otra clase
    var userData by mutableStateOf(User())
    private set

    val currentUser = authUseCases.getCurrentUser()

    init {
        getUserById()
    }

    private fun getUserById() = viewModelScope.launch {
        usersUseCases.getUserById(currentUser!!.uid).collect(){
            userData = it
        }
    }
    fun logout() {
        authUseCases.logout()
    }
}