package com.bookora.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface Route : NavKey

@Serializable
data object MainRoute : Route

@Serializable
data object ProfileRoute : Route

@Serializable
data object SettingsRoute : Route

