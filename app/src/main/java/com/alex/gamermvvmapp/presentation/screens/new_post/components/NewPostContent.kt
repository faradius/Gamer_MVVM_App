package com.alex.gamermvvmapp.presentation.screens.new_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.gamermvvmapp.R
import com.alex.gamermvvmapp.presentation.components.DefaultTextField
import com.alex.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alex.gamermvvmapp.presentation.ui.theme.Red500

data class CategoryRadioButton(
    var category: String,
    var image: Int
)
@Composable
fun NewPostContent() {

    val radioOptions =  listOf(
        CategoryRadioButton("PC", R.drawable.icon_pc),
        CategoryRadioButton("PS4", R.drawable.icon_ps4),
        CategoryRadioButton("XBOX", R.drawable.icon_xbox),
        CategoryRadioButton("NINTENDO", R.drawable.icon_nintendo),
        CategoryRadioButton("MOBIL", R.drawable.icon_mobile)

    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(Red500)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        modifier = Modifier
                            .height(120.dp)
                            .padding(top = 20.dp),
                        painter = painterResource(id = R.drawable.add_image),
                        contentDescription = ""
                    )

                    Text(
                        text = "SELECCIONA UNA IMAGEN",
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
                    .padding(horizontal = 20.dp),
                value = "",
                onValueChange = { },
                label = "Nombre del juego",
                icon = Icons.Default.Face,
                errorMsg = "",
                validateField = {

                }
            )

            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp)
                    .padding(horizontal = 20.dp),
                value = "",
                onValueChange = { },
                label = "Descripción",
                icon = Icons.Default.List,
                errorMsg = "",
                validateField = {

                }
            )

            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "CATEGORIAS",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            radioOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .selectable(
                            selected = false,
                            onClick = {

                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier.width(100.dp),
                            text = option.category
                        )
                        Image(
                            modifier = Modifier.height(30.dp),
                            painter = painterResource(id = option.image),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewPostPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {
            NewPostContent()
        }
    }

}