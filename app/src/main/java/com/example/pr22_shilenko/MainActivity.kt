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
import androidx.compose.ui.unit.sp

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Игра Memory",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

            }
        ) {
            Text(text = "Начать игру")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            }
        ) {
            Text(text = "Рекорды")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            }
        ) {
            Text(text = "Настройки")
        }

    }
}