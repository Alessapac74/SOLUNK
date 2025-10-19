import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun SearcScreen() {
    val filtersChecked = remember { mutableStateOf(false) }
    val searchText = remember { mutableStateOf("¿Qué estas buscando?") }

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
            val (titleRef, filtersRef, contentRef, bottomNavRef) = createRefs()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(titleRef) {
                        top.linkTo(parent.top, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(8.dp)),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Checkbox "filtros" en cuadro gris más pequeño
            Row(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .constrainAs(filtersRef) {
                        top.linkTo(titleRef.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "filtros",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Contenido de los filtros repetidos
            Column(
                modifier = Modifier.constrainAs(contentRef) {
                    top.linkTo(filtersRef.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                // Repetir el bloque de filtros 5 veces
                repeat(5) {
                    FilterIte()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Navegación inferior - ACTUALIZADA CON LA NUEVA BARRA
            BottomNavigatio(
                modifier = Modifier.constrainAs(bottomNavRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}

@Composable
fun FilterIte() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Avatar del tutor (lado izquierdo)
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray.copy(alpha = 0.5f))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "T",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Información del tutor (lado derecho)
        Column {
            Text(
                text = "Nombre del Tutor",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Text(text = "Tarifa")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Ubicacion")
            Text(text = "Calificación del tutor")
            Text(text = "Informacion de cursos")
        }
    }
}

@Composable
fun BottomNavigatio(modifier: Modifier = Modifier) {
    BottomAppBar(
        containerColor = Color.LightGray, // COLOR GRIS CLARO
        contentColor = Color.Black, // Color del texto e iconos en negro para mejor contraste
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround
        ) {
            // Buscar
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Buscar",
                    fontSize = 12.sp
                )
            }

            // Mensajes
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Mensajes",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Mensajes",
                    fontSize = 12.sp
                )
            }

            // Favoritos
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favoritos",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Favoritos",
                    fontSize = 12.sp
                )
            }

            // Perfil
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Perfil",
                    fontSize = 12.sp
                )
            }
        }
    }
}