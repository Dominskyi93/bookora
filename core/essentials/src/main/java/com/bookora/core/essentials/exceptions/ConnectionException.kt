package com.bookora.core.essentials.exceptions

import com.bookora.core.essentials.exceptions.base.AbstractCoreAppException
import com.bookora.core.essentials.resources.CoreStringProvider

class ConnectionException(
    cause: Throwable? = null
) : AbstractCoreAppException("Network exception", cause) {

    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}