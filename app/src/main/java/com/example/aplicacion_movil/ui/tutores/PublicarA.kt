package com.example.aplicacion_movil.ui.tutores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun PublishAdScreen() {
    val presencialChecked = remember { mutableStateOf(false) }
    val onlineChecked = remember { mutableStateOf(false) }
    val localidadChecked = remember { mutableStateOf(true) }
    val avisoLegalChecked = remember { mutableStateOf(false) }
    val materiaText = remember { mutableStateOf("") }
    val tituloText = remember { mutableStateOf("") }
    val telefonoText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = "Anunciarse como profesor particular gratis",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                Text(
                    text = "¿Qué estilo de clases ofreces?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Checkbox(
                        checked = presencialChecked.value,
                        onCheckedChange = { presencialChecked.value = it }
                    )
                    Text(
                        text = "Clases presenciales",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 24.dp)
                ) {
                    Checkbox(
                        checked = onlineChecked.value,
                        onCheckedChange = { onlineChecked.value = it }
                    )
                    Text(
                        text = "Clases online",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Text(
                    text = "Materia. Ej: inglés, física...",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = materiaText.value,
                    onValueChange = { materiaText.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                )

                Text(
                    text = "Título del anuncio ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = tituloText.value,
                    onValueChange = { tituloText.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                )


                Text(
                    text = "Teléfono ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = telefonoText.value,
                    onValueChange = { telefonoText.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Checkbox(
                        checked = localidadChecked.value,
                        onCheckedChange = { localidadChecked.value = it }
                    )
                    Text(
                        text = "Localidad",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 24.dp)
                ) {
                    Checkbox(
                        checked = avisoLegalChecked.value,
                        onCheckedChange = { avisoLegalChecked.value = it }
                    )
                    Text(
                        text = "Acepto el aviso legal y de privacidad",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Button(
                    onClick = { /* Acción de publicar anuncio */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Publicar mi anuncio ahora",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}