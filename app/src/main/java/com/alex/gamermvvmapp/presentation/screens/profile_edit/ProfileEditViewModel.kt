package com.alex.gamermvvmapp.presentation.screens.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor() : ViewModel(){

    var state by mutableStateOf(ProfileEditState())
        private set

    var usernameErrorMsg: String by mutableStateOf("")
        private set

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun validateUsername() {
        if (state.username.length >= 3) {
            usernameErrorMsg = ""
        } else {
            usernameErrorMsg = "Al menos 5 caracteres"
        }
    }
}