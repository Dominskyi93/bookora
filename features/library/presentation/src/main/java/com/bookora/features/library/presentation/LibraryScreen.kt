package com.bookora.features.library.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bookora.navigation.dsl.ScreenScope
import com.bookora.navigation.dsl.ScreenToolbar

fun ScreenScope.libraryScreen() {

    toolbar = ScreenToolbar.Default(
        title = "Bookora"
    )

    content {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            Text(text = "Library Screen")
        }
    }
}