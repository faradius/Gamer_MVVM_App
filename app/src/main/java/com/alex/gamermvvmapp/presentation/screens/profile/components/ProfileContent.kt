package com.alex.gamermvvmapp.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.presentation.MainActivity
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.navigation.graphs.Graph
import com.alex.gamermvvmapp.presentation.navigation.routes.AuthScreen
import com.alex.gamermvvmapp.presentation.navigation.routes.DetailsScreen
import com.alex.gamermvvmapp.presentation.screens.profile.ProfileViewModel
import com.alex.gamermvvmapp.presentation.ui.theme.DarkGray500

@Composable
fun ProfileContent(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(55.dp))
                if (viewModel.userData.image != ""){
                    AsyncImage(
                        modifier = Modifier.size(115.dp).clip(CircleShape),
                        model = viewModel.userData.image,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                }else{
                    Image(
                        modifier = Modifier.size(115.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }

            }
        }

        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = viewModel.userData.email,
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(20.dp))

        DefaultButtom(
            modifier = Modifier.width(250.dp),
            text = "Editar datos",
            color = Color.White,
            textColor = DarkGray500,
            icon = Icons.Default.Edit,
            onClick = {
                navController.navigate(route = DetailsScreen.ProfileUpdate.passUser(viewModel.userData.toJson()))
            })

        Spacer(modifier = Modifier.height(10.dp))

        DefaultButtom(
            modifier = Modifier.width(250.dp),
            text = "Cerrar Sesión",
            icon = Icons.Default.ExitToApp,
            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            })

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileContent() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileContent(rememberNavController())
        }
    }
}