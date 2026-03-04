package br.edu.ifsp.scl.sc3044025.trucoscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components.ResetButton
import br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components.ScoreColumn
import br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components.TrucoButton
import br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.Components.WinnerAlertDialog
import br.edu.ifsp.scl.sc3044025.trucoscoreboard.ui.theme.TrucoScoredBoardTheme
import java.time.temporal.IsoFields

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoredBoardTheme(){
                Surface(modifier = Modifier.fillMaxSize()){
                    TrucoScorePanel()
                }
            }
        }
    }
}

@Composable
fun TrucoScorePanel(){
    var pontNos by remember { mutableIntStateOf(0) }
    var pontEles by remember { mutableIntStateOf(0) }

    var pontoMaximo = 12

    var showWinnerDialog by remember { mutableStateOf(false) }
    var winnerTeam by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ScoreColumn(
                title = "EQUIPE A",
                score = pontNos,
                onAddScore = { value ->
                    pontNos = (pontNos + value).coerceAtMost(pontoMaximo)
                },
                modifier = Modifier.weight(1f)
            )

            ScoreColumn(
                title = "EQUIPE B",
                score = pontEles,
                onAddScore = { value ->
                    pontEles = (pontEles + value).coerceAtMost(pontoMaximo)
                },
                modifier = Modifier.weight(1f)
            )
        }
        ResetButton {
            pontEles = 0
            pontNos = 0
        }
        if (pontNos >= 12 && !showWinnerDialog) {
            winnerTeam = "Equipe A"
            showWinnerDialog = true
        } else if (pontEles >= 12 && !showWinnerDialog) {
            winnerTeam = "Equipe B"
            showWinnerDialog = true
        }

    }
    if (showWinnerDialog) {
        WinnerAlertDialog(teamName = winnerTeam) {
            showWinnerDialog = false
            pontNos = 0
            pontEles = 0
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrucoScorePanel()
}