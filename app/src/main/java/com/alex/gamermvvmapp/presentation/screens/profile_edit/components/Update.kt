package com.alex.gamermvvmapp.presentation.screens.profile_edit.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.gamermvvmapp.domain.model.Response
import com.alex.gamermvvmapp.domain.use_cases.users.Update
import com.alex.gamermvvmapp.presentation.components.ProgressBar
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun Update(viewModel: ProfileEditViewModel = hiltViewModel()){
    when(val updateResponse = viewModel.updateResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Datos actualizados correctamente", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, updateResponse.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> Log.d("SignUpContent", "SignUpContent Error: Error desconocido")
    }
}