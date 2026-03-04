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
fun TrucoButton(
    value: Int,
    enable: Boolean,
    onclick: () -> Unit
){
    Button(
        onClick = onclick,
        enabled = enable,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFD32F2F),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFF606060),
            disabledContentColor = Color.LightGray
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = "+$value",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}