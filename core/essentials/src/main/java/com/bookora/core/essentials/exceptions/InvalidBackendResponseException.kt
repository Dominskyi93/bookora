package com.bookora.core.essentials.exceptions

import com.bookora.core.essentials.exceptions.base.AbstractCoreAppException
import com.bookora.core.essentials.resources.CoreStringProvider

class InvalidBackendResponseException(
    cause: Throwable?
) : AbstractCoreAppException("Can`t parse server response", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.invalidBackendResponseErrorMessage
    }
}