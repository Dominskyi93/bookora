package com.bookora.core.data.network.converters

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

internal fun createDefaultJson(
    isDebug: Boolean
): Json {
    return Json {
        if (isDebug) {
            prettyPrint = true
        }
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        namingStrategy = JsonNamingStrategy.SnakeCase
    }
}