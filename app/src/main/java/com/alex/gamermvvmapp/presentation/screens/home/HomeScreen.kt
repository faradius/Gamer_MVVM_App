package com.alex.gamermvvmapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alex.gamermvvmapp.presentation.navigation.HomeBottomBarNavGraph

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            HomeBottomBarNavGraph(navController = navController)
        }

    }
}