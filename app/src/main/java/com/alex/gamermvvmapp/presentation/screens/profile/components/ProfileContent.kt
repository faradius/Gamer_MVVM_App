package com.alex.gamermvvmapp.presentation.screens.profile.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

@Composable
fun ProfileContent(){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileContent(){
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileContent()
        }
    }
}