package com.bookora.core.essentials.exceptions.mapper

import com.bookora.core.essentials.exceptions.base.WithLocalizedMessage
import com.bookora.core.essentials.resources.CoreStringProvider
import com.bookora.core.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
) : ExceptionToMessageMapper {
    override fun getLocalizedMessage(exception: Exception): String {
        return if (exception is WithLocalizedMessage) {
            exception.getLocalizedErrorMessage(stringProviderStore)
        } else {
            stringProviderStore<CoreStringProvider>().unknownErrorMessage
        }
    }
}