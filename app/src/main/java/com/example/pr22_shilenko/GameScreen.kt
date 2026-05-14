package com.example.pr22_shilenko

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay


@Composable
fun GameScreen() {

    val cards = remember {

        mutableStateListOf<CardItem>().apply {

            val emojis = listOf(
                "🐶", "🐱", "🐭", "🐹", "🐰", "🦊",
                "🐻", "🐼", "🐨", "🐯", "🦁", "🐮",
                "🐷", "🐸", "🐵", "🐔", "🐧", "🐦"
            )

            for (emoji in emojis) {

                add(CardItem(emoji))
                add(CardItem(emoji))
            }

            shuffle()
        }
    }
    var firstOpenedCard: CardItem? = remember { null }
    var secondOpenedCard: CardItem? = remember { null }
    var moves by remember { mutableStateOf(0) }
    var isGameFinished by remember { mutableStateOf(false) }
    fun restartGame() {

        cards.clear()

        val emojis = listOf(
            "🐶", "🐱", "🐭", "🐹", "🐰", "🦊",
            "🐻", "🐼", "🐨", "🐯", "🦁", "🐮",
            "🐷", "🐸", "🐵", "🐔", "🐧", "🐦"
        )

        for (emoji in emojis) {

            cards.add(CardItem(emoji))
            cards.add(CardItem(emoji))
        }

        cards.shuffle()

        moves = 0

        firstOpenedCard = null
        secondOpenedCard = null

        isGameFinished = false
    }

    LaunchedEffect(cards.size) {

        cards.forEach {
            it.isOpened = true
        }

        delay(5000)

        cards.forEach {
            it.isOpened = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
            .padding(8.dp)
    ) {

        Text(
            text = "Memory Game",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Ходы: $moves"
        )

        Spacer(modifier = Modifier.height(10.dp))
        if (isGameFinished) {

            Text(
                text = "Игра окончена!",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    restartGame()
                }
            ) {
                Text(text = "Новая игра")
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(6)
        ) {

            items(cards) { card ->

                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(50.dp)
                        .border(1.dp, Color.Black)
                        .clickable {
                            if (!card.isOpened && !card.isMatched) {

                                card.isOpened = true

                                if (firstOpenedCard == null) {

                                    firstOpenedCard = card

                                } else if (secondOpenedCard == null) {

                                    secondOpenedCard = card
                                    moves++

                                    if (firstOpenedCard?.imageName ==
                                        secondOpenedCard?.imageName
                                    ) {

                                        firstOpenedCard?.isMatched = true
                                        secondOpenedCard?.isMatched = true

                                    } else {

                                        android.os.Handler().postDelayed({

                                            firstOpenedCard?.isOpened = false
                                            secondOpenedCard?.isOpened = false

                                            firstOpenedCard = null
                                            secondOpenedCard = null

                                        }, 1000)

                                        return@clickable
                                    }

                                    firstOpenedCard = null
                                    secondOpenedCard = null
                                    if (cards.all { it.isMatched }) {
                                        isGameFinished = true
                                    }
                                }
                            }
                        }
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = if (card.isOpened)
                                card.imageName
                            else
                                "?"
                        )

                    }
                }
            }
        }
    }
}