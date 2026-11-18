package com.bookora.core.common.android

import com.bookora.core.essentials.logger.Logger
import timber.log.Timber
import javax.inject.Inject

class AndroidLogger @Inject constructor() : Logger {
    override fun d(message: String) {
        Timber.d(message)
    }

    override fun e(exception: Exception, message: String) {
        Timber.d(exception, message)
    }
}