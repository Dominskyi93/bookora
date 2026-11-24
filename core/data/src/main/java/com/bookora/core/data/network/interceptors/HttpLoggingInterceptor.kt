package com.bookora.core.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal fun createHttpLoggingInterceptor(
    isDebug: Boolean
): Interceptor {
    val level = if (isDebug) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
    return HttpLoggingInterceptor().setLevel(level)
}