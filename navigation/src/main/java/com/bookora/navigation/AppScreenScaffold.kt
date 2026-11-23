package com.bookora.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookora.navigation.dsl.ScreenNavigationBar
import com.bookora.navigation.dsl.ScreenToolbar

@Composable
fun AppScreenScaffold(
    navigationBar: ScreenNavigationBar,
    onBackPressed: () -> Unit,
    showBackButton: Boolean,
    toolbar: ScreenToolbar,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            if (toolbar is ScreenToolbar.Default) {
                val actionButton = toolbar.action

                AppToolbar(
                    title = toolbar.title,
                    showBackButton = showBackButton,
                    onBackPressed = onBackPressed,
                    actionButtonIcon = actionButton?.icon,
                    onPressedActionButton = if (actionButton != null) {
                        actionButton.onClick
                    } else {
                        {}
                    }
                )
            }
        },
        bottomBar = {
            if (navigationBar is ScreenNavigationBar.Default) {
                AppNavigationBar(
                    navigationBar = navigationBar
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content()
        }
    }
}