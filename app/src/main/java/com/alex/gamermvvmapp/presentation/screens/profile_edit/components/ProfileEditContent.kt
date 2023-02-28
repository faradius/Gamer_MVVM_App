package com.alex.gamermvvmapp.presentation.screens.profile_edit.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.presentation.components.DefaultButtom
import com.alex.gamermvvmapp.presentation.components.DefaultTextField
import com.alex.gamermvvmapp.presentation.screens.profile_edit.ProfileEditViewModel
import com.alex.gamermvvmapp.presentation.ui.theme.DarkGray500
import com.alex.gamermvvmapp.presentation.ui.theme.Red500
import com.alex.gamermvvmapp.presentation.utils.ComposeFileProvider

@Composable
fun ProfileEditContent(
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel()
) {
    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()

    Box(
        modifier = Modifier
            //.padding()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Red500)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))

                if (viewModel.imageUri != "") {
                    AsyncImage(
                        modifier = Modifier
                            .height(110.dp)
                            .width(110.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        model = viewModel.imageUri,
                        contentDescription = "Selected image"
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .height(110.dp)
                            .clickable {
                                viewModel.takePhoto()
                            },
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Imagen de usuario"
                    )
                }


            }

        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 160.dp),
            backgroundColor = DarkGray500
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 40.dp),
                    text = "ACTUALIZACIÓN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Modifique los datos que desea actualizar",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = state.username,
                    onValueChange = { viewModel.onUsernameInput(it) },
                    label = "Nombre de Usuario",
                    icon = Icons.Default.Person,
                    errorMsg = viewModel.usernameErrorMsg,
                    validateField = {
                        viewModel.validateUsername()
                    }
                )

                DefaultButtom(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 40.dp),
                    text = "ACTUALIZAR DATOS",
                    onClick = { viewModel.onUpdate() }
                )
            }
        }

    }
}