package com.bookora.core.essentials.exceptions

import com.bookora.core.essentials.exceptions.base.AbstractAppException

class UnknownException(
    cause: Throwable
) : AbstractAppException("Unknown exception", cause)
