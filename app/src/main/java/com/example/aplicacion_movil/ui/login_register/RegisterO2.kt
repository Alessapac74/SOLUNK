package com.example.aplicacion_movil.ui.login_register

import androidx.compose.foundation.Image
import com.example.aplicacion_movil.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun RegisterS() {
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
            val (titleRef, googleButtonRef, emailButtonRef, logoRef) = createRefs()

            Text(
                text = "Registro gratuito",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top, margin = 80.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Spacer(modifier = Modifier.height(60.dp))

            // Botón "Continuar con Google"
            Button(
                onClick = { /* Acción para continuar con Google */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(googleButtonRef) {
                        top.linkTo(titleRef.bottom, margin = 60.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Continuar con Google", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón "Continuar con mi email"
            Button(
                onClick = { /* Acción para continuar con email */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(emailButtonRef) {
                        top.linkTo(googleButtonRef.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                 colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Continuar con mi email", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(40.dp))


            Box(modifier = Modifier.constrainAs(logoRef){
                top.linkTo(emailButtonRef.bottom, margin = 40.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)

            }){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(300.dp)
                        .padding(bottom = 40.dp)
                )

            }
        }
    }
}