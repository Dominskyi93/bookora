package com.bookora.core.essentials.exceptions.base

import com.bookora.core.essentials.resources.StringProviderStore

interface WithLocalizedMessage {
    fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String
}