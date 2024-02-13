package com.alex.gamermvvmapp.presentation.screens.my_posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.navigation.routes.DetailsScreen


@Composable
fun MyPostsScreen(navController: NavHostController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(DetailsScreen.NewPost.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "My Posts Screen")
        }
    }
}