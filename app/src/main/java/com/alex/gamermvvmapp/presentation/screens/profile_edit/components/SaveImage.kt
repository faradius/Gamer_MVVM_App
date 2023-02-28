package com.alex.gamermvvmapp.presentation.screens.profile_edit.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.use_cases.users.SaveImage
import com.alex.gamermvvmapp.presentation.components.ProgressBar
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun SaveImage(viewModel: ProfileEditViewModel = hiltViewModel()) {
    when (val response = viewModel.saveImageResponse) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.onUpdate(response.data)
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> Log.d("SaveImageProfile", "SaveImageProfile Error: Error desconocido")
    }
}