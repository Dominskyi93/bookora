package com.bookora.core.data.network

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

data class NetworkConfig(
    val baseUrl: String = "https://openlibrary.org/",
    val timeout: Duration = 10.seconds,
    val isDebug: Boolean = true
)
