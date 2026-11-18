package com.bookora.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object MainRoute : Route