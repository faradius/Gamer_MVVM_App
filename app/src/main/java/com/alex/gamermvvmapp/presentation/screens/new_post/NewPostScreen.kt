package com.alex.gamermvvmapp.presentation.screens.new_post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.components.DefaultTopBar
import com.alex.gamermvvmapp.presentation.screens.new_post.components.NewPostContent

@Composable
fun NewPostScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Post",
                upAvailable = true,
                navController = navController
            )
        },
        bottomBar ={
            DefaultButtom(
                modifier = Modifier.fillMaxWidth(),
                text = "Publicar",
                onClick = { /*TODO*/ })
        }
    ) {
        Column (
            modifier = Modifier.padding(it)
        ){
            NewPostContent()
        }

    }
}