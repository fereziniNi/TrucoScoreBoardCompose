package br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MaoDeOnze() {
    Text(
        text = "🖐️ Mão de Onze",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF2E7D32),
        modifier = Modifier.padding(top = 4.dp)
    )
}