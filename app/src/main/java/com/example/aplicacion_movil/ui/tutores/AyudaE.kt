package com.example.aplicacion_movil.ui.tutores

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.aplicacion_movil.R

@Preview(showSystemUi = true)
@Composable
fun PantallaAyuda(onCloseClick: () -> Unit = {}) {

    // Estado del rol seleccionado
    var rolSeleccionado by rememberSaveable { mutableStateOf("") }

    // Texto dinámico según la selección
    val textoFrecuente = when (rolSeleccionado) {
        "Alumno" -> "Preguntas Frecuentes que hagan los usuarios de alumnos"
        "Profesor" -> "Preguntas Frecuentes que hagan los usuarios de profesores"
        "Academia" -> "Preguntas Frecuentes que hagan los usuarios de profesores que quieran presentar a una academia"
        else -> "Selecciona una opción para ver las preguntas frecuentes"
    }

    // Fondo principal
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            // 🔹 Título
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ayuda",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Texto principal
            Text(
                text = "¿En qué podemos ayudarte?",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "Éstas son algunas preguntas frecuentes de alumnos y tutores",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Fila 1: Alumno y Profesor
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OpcionAyuda(
                    texto = "Soy Alumno",
                    seleccionado = rolSeleccionado == "Alumno",
                    colorSeleccion = Color(0xFF00BCD4), // 💠 Cyan
                    onClick = { rolSeleccionado = "Alumno" },
                    icono = R.drawable.logo,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                OpcionAyuda(
                    texto = "Soy Profesor",
                    seleccionado = rolSeleccionado == "Profesor",
                    colorSeleccion = Color(0xFF3F51B5), // 🔵 Azul
                    onClick = { rolSeleccionado = "Profesor" },
                    icono = R.drawable.logo,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Fila 2: Academia
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                OpcionAyuda(
                    texto = "Soy Una Academia",
                    seleccionado = rolSeleccionado == "Academia",
                    colorSeleccion = Color(0xFF9C27B0), // 🟣 Morado
                    onClick = { rolSeleccionado = "Academia" },
                    icono = R.drawable.logo,
                    modifier = Modifier.width(180.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 Cuadro dinámico
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = textoFrecuente,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun OpcionAyuda(
    texto: String,
    seleccionado: Boolean,
    colorSeleccion: Color,
    onClick: () -> Unit,
    icono: Int,
    modifier: Modifier = Modifier
) {
    // Cambiar color dependiendo del estado
    val colorFondo = if (seleccionado) colorSeleccion else Color(0xFFDADADA)

    Column(
        modifier = modifier
            .aspectRatio(1f) // 🔸 Cuadros del mismo tamaño
            .clickable { onClick() }
            .background(colorFondo, RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icono),
            contentDescription = texto,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = texto,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
