package com.bookora.core.common.android.di

import com.bookora.core.common.android.AndroidLogger
import com.bookora.core.common.android.CoreStringProviderImpl
import com.bookora.core.common.android.DateTimeProviderImpl
import com.bookora.core.essentials.datetime.DateTimeProvider
import com.bookora.core.essentials.exceptions.mapper.DefaultExceptionMessageMapper
import com.bookora.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.bookora.core.essentials.logger.Logger
import com.bookora.core.essentials.resources.CoreStringProvider
import com.bookora.core.essentials.resources.StringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
internal interface CommonAndroidModule {

    @Binds
    fun bindDateTimeProvider(
        impl: DateTimeProviderImpl
    ): DateTimeProvider

    @Binds
    fun bindLogger(logger: AndroidLogger): Logger

    @Binds
    @IntoMap
    @ClassKey(CoreStringProvider::class)
    fun bindCoreStringProviderIntoMap(
        impl: CoreStringProviderImpl
    ): StringProvider

    @Binds
    fun bindCoreStringProvider(
        impl: CoreStringProviderImpl
    ): CoreStringProvider

    @Binds
    fun bindExceptionToMessageMapper(
        impl: DefaultExceptionMessageMapper
    ): ExceptionToMessageMapper
}