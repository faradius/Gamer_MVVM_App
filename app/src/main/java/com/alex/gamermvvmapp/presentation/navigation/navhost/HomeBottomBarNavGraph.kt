package com.alex.gamermvvmapp.presentation.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.gamermvvmapp.presentation.navigation.graphs.Graph
import com.alex.gamermvvmapp.presentation.navigation.routes.HomeBottomBarScreen
import com.alex.gamermvvmapp.presentation.screens.my_posts.MyPostsScreen
import com.alex.gamermvvmapp.presentation.screens.posts.PostsScreen
import com.alex.gamermvvmapp.presentation.screens.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {
        composable(route = HomeBottomBarScreen.Posts.route) {
            PostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.MyPosts.route) {
            MyPostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }

        detailNavGraph(navController = navController)
    }
}