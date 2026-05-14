package com.example.pr22_shilenko

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CardItem(
    val imageName: String
) {
    var isOpened by mutableStateOf(false)

    var isMatched by mutableStateOf(false)
}