package com.bookora.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object MainRoute : Route

@Serializable
data object ProfileRoute : Route

@Serializable
data object SettingsRoute : Route

