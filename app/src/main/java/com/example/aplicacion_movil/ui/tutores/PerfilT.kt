package com.example.aplicacion_movil.ui.tutores

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.aplicacion_movil.R

@Composable
fun PerfilInstructorScreen(
    onBackClick: () -> Unit = {}
) {
    // --- Ejemplo de uso de remember y rememberSaveable ---
    var nombre by rememberSaveable { mutableStateOf("Nombre del Instructor") }
    var cursos by remember { mutableStateOf("Curso o Cursos a dictar y si es presencial u online") }
    var info by rememberSaveable { mutableStateOf("Información sobre sus especialidades y métodos de enseñanza") }

    // Fondo blanco
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (btnBack, perfilBox, datosBox, cursosBox, infoBox) = createRefs()

            // 🔙 Botón de regreso
            IconButton(
                onClick = { onBackClick() },
                modifier = Modifier.constrainAs(btnBack) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
            ) {
            }

            // 🧑 Imagen del perfil
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
                    .constrainAs(perfilBox) {
                        top.linkTo(btnBack.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp)
                )
            }

            // 💬 Datos principales
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.Blue, RoundedCornerShape(6.dp))
                    .constrainAs(datosBox) {
                        top.linkTo(perfilBox.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("S/. Tarifa", fontSize = 14.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null)
                        Text("5 opiniones", fontSize = 14.sp)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                        Text("Añadir a favoritos", fontSize = 14.sp)
                    }
                }
            }

            // 🏫 Cursos
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .border(1.dp, Color.Blue, RoundedCornerShape(6.dp))
                    .background(Color(0xFFEFEFEF))
                    .constrainAs(cursosBox) {
                        top.linkTo(datosBox.bottom, margin = 12.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = cursos,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )

                // Ejemplo de TextField editable
                TextField(
                    value = cursos,
                    onValueChange = { cursos = it },
                    label = { Text("Editar cursos") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            // 📘 Información adicional
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .border(1.dp, Color.Blue, RoundedCornerShape(6.dp))
                    .background(Color(0xFFEFEFEF))
                    .constrainAs(infoBox) {
                        top.linkTo(cursosBox.bottom, margin = 12.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = info,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp)
                )

                // TextField con rememberSaveable
                TextField(
                    value = info,
                    onValueChange = { info = it },
                    label = { Text("Editar información") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaPerfilInstructor() {
    PerfilInstructorScreen()
}