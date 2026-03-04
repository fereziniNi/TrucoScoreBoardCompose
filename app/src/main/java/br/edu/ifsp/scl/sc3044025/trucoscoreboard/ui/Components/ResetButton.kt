package br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResetButton(
    onclick : () -> Unit
){
    Button(
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFD32F2F),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "ZERAR JOGO",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}