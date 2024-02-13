package com.alex.gamermvvmapp.presentation.navigation.navhost

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.alex.gamermvvmapp.presentation.navigation.graphs.Graph
import com.alex.gamermvvmapp.presentation.navigation.routes.AuthScreen
import com.alex.gamermvvmapp.presentation.navigation.routes.DetailsScreen
import com.alex.gamermvvmapp.presentation.screens.new_post.NewPostScreen
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditScreen

fun NavGraphBuilder.detailNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ){
        composable(route = DetailsScreen.NewPost.route){
            NewPostScreen(navController)
        }

        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let{
                ProfileEditScreen(navController)
            }

        }
    }
}