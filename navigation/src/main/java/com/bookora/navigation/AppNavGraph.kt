package com.bookora.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SupervisorAccount
import com.bookora.features.library.presentation.libraryScreen
import com.bookora.features.main.presentation.Tab
import com.bookora.features.main.presentation.mainScreen
import com.bookora.navigation.base.ExtendedNavGraphBuilder
import com.bookora.navigation.base.composable
import com.bookora.templates.feature.presentation.profileScreen

fun ExtendedNavGraphBuilder.buildAppNavGraph() {
    composable<MainRoute> {
        mainScreen(
            Tab(
                icon = Icons.AutoMirrored.Default.LibraryBooks,
                label = {
                    "Library"
                    //    getString(ChatsR.string.chats_title)
                },
                configuration = {
                    libraryScreen()
                }
            ),
            Tab(
                icon = Icons.Default.Search,
                label = {
                    "Search"
//                    getString(ProfileR.string.profile)
                },
                configuration = {
//                    profileScreen()
                }
            ),

            Tab(
                icon = Icons.Default.Checklist,
                label = {
                    "Checklist"
//                    getString(SettingsR.string.settings_title)
                },
                configuration = {
//                    settingsScreen()
                }
            ),
            Tab(
                icon = Icons.Default.SupervisorAccount,
                label = {
                    "Profile"
                    //    getString(ChatsR.string.chats_title)
                },
                configuration = {
                    profileScreen()
                }
            )
        )
    }
}