package com.bookora.features.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bookora.navigation.dsl.ScreenScope
import com.bookora.navigation.dsl.ScreenToolbar


fun ScreenScope.profileScreen() {
    val viewModel: ProfileVM = viewModel(ProfileVM::class)

    toolbar = ScreenToolbar.Default()

    content {
        ProfileScreenContent()
    }

}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Profile Screen")
    }

}