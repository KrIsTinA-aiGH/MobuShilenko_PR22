package com.example.pr22_shilenko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    StartScreen()
                }

            }
        }
    }
}

@Composable
fun StartScreen() {

    var screen by remember { mutableStateOf("start") }

    when (screen) {
        "start" -> MenuScreen(
            onStartClick = { screen = "game" },
            onRecordsClick = { screen = "records" },
            onSettingsClick = { screen = "settings" }
        )

        "game" -> GameScreen()

        "records" -> Text(text = "Здесь будут рекорды")

        "settings" -> Text(text = "Здесь будут настройки")
    }
}
@Composable
fun MenuScreen(
    onStartClick: () -> Unit,
    onRecordsClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text( text = "Memory Game" )


        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onStartClick) {
            Text(text = "Начать игру")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onRecordsClick) {
            Text(text = "Рекорды")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onSettingsClick) {
            Text(text = "Настройки")
        }
    }
}