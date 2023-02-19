package com.alex.gamermvvmapp.presentation.components

import android.support.v4.os.IResultReceiver.Default
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alex.gamermvvmapp.presentation.ui.theme.Red500
import com.alex.gamermvvmapp.presentation.ui.theme.Red700

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null
){
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp
            )
        },
        backgroundColor = Red500,
        navigationIcon = {
            if (upAvailable){
                IconButton(onClick = { navController?.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}