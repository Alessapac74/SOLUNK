package com.example.aplicacion_movil.ui.login_register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.aplicacion_movil.R

@Preview(showBackground = true)
@Composable
fun TutoriaPortalScreen() {
    val rememberState = remember { "Estado recordado" }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val (titleRef, subtitleRef, buttonsRef) = createRefs()

            Text(
                text = "Registro gratuito",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Text(
                text = "Unite gratis al portal de\ntutoria",
                fontSize = 18.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.constrainAs(subtitleRef) {
                    top.linkTo(titleRef.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Column(
                modifier = Modifier.constrainAs(buttonsRef) {
                    top.linkTo(subtitleRef.bottom, margin = 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
                    Image(

                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(bottom = 40.dp)
                    )
                }
                Button(
                    onClick = { /* Acción para buscar tutoría */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Buscar tutoria")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 40.dp)
                )
}
                Button(
                    onClick = { /* Acción para impartir tutoría */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Impartir tutoria")
                }
            }
        }
    }
}