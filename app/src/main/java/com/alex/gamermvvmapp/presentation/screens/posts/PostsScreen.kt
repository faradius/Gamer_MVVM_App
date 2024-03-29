package com.alex.gamermvvmapp.presentation.screens.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun PostsScreen(navController: NavHostController) {

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Posts Screen")
        }
    }
}