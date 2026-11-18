package com.bookora.core.essentials.exceptions.base

abstract class AbstractAppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)

