package com.example.aplicacion_movil.ui.login_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            val (titleRef, emailRef, passwordRef, loginButtonRef, forgotPasswordRef, googleOptionRef) = createRefs()

            // Título "Iniciar Sesión"
            Text(
                text = "Iniciar Sesión",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top, margin = 80.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Campo Email
            Column(
                modifier = Modifier.constrainAs(emailRef) {
                    top.linkTo(titleRef.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Ingresa tu email") }
                )
            }

            // Campo Contraseña
            Column(
                modifier = Modifier.constrainAs(passwordRef) {
                    top.linkTo(emailRef.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Text(
                    text = "Contraseña",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Ingresa tu contraseña") }
                )
            }

            // Botón Iniciar Sesión
            Button(
                onClick = { /* Acción de login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(loginButtonRef) {
                        top.linkTo(passwordRef.bottom, margin = 30.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text("Iniciar Sesión", fontSize = 16.sp)
            }

            // ¿Olvidaste la contraseña?
            TextButton(
                onClick = { /* Acción para recuperar contraseña */ },
                modifier = Modifier.constrainAs(forgotPasswordRef) {
                    top.linkTo(loginButtonRef.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Text("¿Olvidaste la contraseña?")
            }

            // Opción Continuar con Google
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.constrainAs(googleOptionRef) {
                    top.linkTo(forgotPasswordRef.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Button(onClick = { /* Acción de login */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red)
                        ) {
                    Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )

                Text(
                    text = "Continuar con Google",
                    modifier = Modifier.padding(start = 8.dp)
                )
                }

            }
        }
    }
}