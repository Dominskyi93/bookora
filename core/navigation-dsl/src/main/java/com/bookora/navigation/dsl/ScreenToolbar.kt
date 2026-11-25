package com.bookora.navigation.dsl

import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenToolbar {

    data object Hidden : ScreenToolbar()

    data class Default(
        val title: String = "Bookora",
        val action: Action? = null
    ) : ScreenToolbar()
}

data class Action(
    val icon: ImageVector,
    val onClick: () -> Unit
)