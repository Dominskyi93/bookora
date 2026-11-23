package com.bookora.features.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bookora.navigation.dsl.ScreenScope


fun ScreenScope.profileScreen() {

//    toolbar = ScreenToolbar.Default(
//        title = context.getString(R.string.chats_title),
//        action = Action(
//            icon = Icons.Filled.AddCircle,
//            onClick = {
//                viewModel.showBottomSheet()
//            }
//        )
//    )

    content {
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

}