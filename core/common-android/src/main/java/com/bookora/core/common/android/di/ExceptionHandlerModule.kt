package com.bookora.core.common.android.di

import com.bookora.core.common.android.AndroidExceptionHandler
import com.bookora.core.essentials.exceptions.handler.ExceptionHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface ExceptionHandlerModule {

    @Binds
    fun bindExceptionHandler(
        impl: AndroidExceptionHandler
    ): ExceptionHandler
}