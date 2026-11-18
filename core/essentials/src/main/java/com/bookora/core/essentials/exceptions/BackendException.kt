package com.bookora.core.essentials.exceptions

import com.bookora.core.essentials.exceptions.base.AbstractCoreAppException
import com.bookora.core.essentials.resources.CoreStringProvider

class BackendException(
    val httpCode: Int = 400,
    val backendMessage: String = "",
    cause: Throwable? = null
) : AbstractCoreAppException("Server error", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.backendErrorMessage(httpCode, backendMessage)
    }
}