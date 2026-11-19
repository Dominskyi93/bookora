package com.bookora.features.main.presentation

import android.content.Context
import androidx.compose.ui.graphics.vector.ImageVector
import com.bookora.navigation.dsl.ScreenScope

data class Tab(
    val icon: ImageVector,
    val label: Context.() -> String,
    val configuration: ScreenScope.() -> Unit
)