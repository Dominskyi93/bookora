package com.bookora.core.data.network.converters

import kotlinx.serialization.json.Json

@PublishedApi
internal val errorJson = Json {
    explicitNulls = false
    ignoreUnknownKeys = true
}
