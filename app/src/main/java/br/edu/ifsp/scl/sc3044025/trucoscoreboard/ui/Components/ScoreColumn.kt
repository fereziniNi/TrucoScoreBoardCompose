package br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScoreColumn(
    title: String,
    score: Int,
    onAddScore: (value: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 50.dp)
    ) {

        TitleTeam(title)

        if (score == 11) {
            MaoDeOnze()
        }

        TitleNumber(score)

        PlusButton(value = 1, onClick = { onAddScore(1) })

        TrucoButton(
            value = 3,
            enable = score < 11
        ) {
            onAddScore(3)
        }
    }
}