package com.alex.gamermvvmapp.presentation.screens.profile_edit

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.model.User
import com.alex.gamermvvmapp.domain.use_cases.users.UsersUseCases
import com.alex.gamermvvmapp.presentation.utils.ComposeFileProvider
import com.alex.gamermvvmapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val usersUseCases: UsersUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var state by mutableStateOf(ProfileEditState())
        private set

    var usernameErrorMsg: String by mutableStateOf("")
        private set

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    var saveImageResponse by mutableStateOf<Response<String>?>(null)
        private set

    //IMAGE
    var imageUri by mutableStateOf("")

    //FILE
    var file: File? = null

    val resultingActivityHandler = ResultingActivityHandler()

    init {
        state = state.copy(username = user.username)
    }

    fun saveImage() = viewModelScope.launch {
        if(file != null){
            saveImageResponse = Response.Loading
            val result = usersUseCases.saveImage(file!!)
            saveImageResponse = result
        }

    }

    //Obtener imagen de galeria
    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            imageUri = result.toString()
        }

    }

    //Tomar foto con la camara
    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            imageUri = ComposeFileProvider.getPathFromBitmap(context, result)
            file = File(imageUri)
        }
    }

    fun onUpdate(url: String) {
        val myUser = User(
            id = user.id,
            username = state.username,
            image = url
        )
        update(myUser)
    }

    fun update(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = usersUseCases.update(user)
        updateResponse = result
    }

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