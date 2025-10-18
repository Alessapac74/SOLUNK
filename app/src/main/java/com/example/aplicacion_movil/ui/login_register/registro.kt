package com.example.aplicacion_movil.ui.login_register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview(showSystemUi = true)
@Composable
fun RegisterScreen() {
    // Estados individuales sin data class
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var aceptoTerminos by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (titleRef, subtitleRef, benefitsRef, formRef, termsRef, buttonRef, loginRef) = createRefs()

                // Título
                Text(
                    text = "Registro gratuito",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .constrainAs(titleRef) {
                            top.linkTo(parent.top, margin = 40.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                )



                Text(
                    text = "Únete gratis al portal líder de clases particulares",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .constrainAs(subtitleRef) {
                            top.linkTo(titleRef.bottom, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                )

                Spacer(
                    modifier = Modifier.constrainAs(benefitsRef) {
                        top.linkTo(subtitleRef.bottom, margin = 60.dp) // ← AQUÍ AUMENTÉ EL ESPACIO
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.value(0.dp) // Spacer invisible
                    }
                )

                Column(
                    modifier = Modifier.constrainAs(formRef) {
                        top.linkTo(benefitsRef.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { newNombre ->
                            nombre = newNombre
                        },
                        label = { Text("Nombre completo") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { newEmail ->
                            email = newEmail
                        },
                        label = { Text("Correo electrónico") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { newPassword ->
                            password = newPassword
                        },
                        label = { Text("Contraseña") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            // Botón de texto en lugar de icono
                            TextButton(
                                onClick = { passwordVisible = !passwordVisible },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Text(
                                    text = if (passwordVisible) "OC" else "MO",
                                    fontSize = 12.sp
                                )
                            }
                        }
                    )
                }

                Row(
                    modifier = Modifier.constrainAs(termsRef) {
                        top.linkTo(formRef.bottom, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = aceptoTerminos,
                        onCheckedChange = { checked ->
                            aceptoTerminos = checked
                        }
                    )
                    Text(
                        text = "Acepto los términos y condiciones",
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 14.sp
                    )
                }

                // Botón de registro
                Button(
                    onClick = {
                        isLoading = true
                        // Lógica de registro aquí
                    },
                    modifier = Modifier
                        .constrainAs(buttonRef) {
                            top.linkTo(termsRef.bottom, margin = 24.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .height(56.dp),
                    enabled = nombre.isNotEmpty() &&
                            email.isNotEmpty() &&
                            password.isNotEmpty() &&
                            aceptoTerminos &&
                            !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text(
                            text = "Registrarse gratis",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                TextButton(
                    onClick = { /* Navegar a login */ },
                    modifier = Modifier.constrainAs(loginRef) {
                        bottom.linkTo(parent.bottom, margin = 40.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                ) {
                    Text(
                        text = "¿Ya tienes cuenta? Inicia sesión",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }

