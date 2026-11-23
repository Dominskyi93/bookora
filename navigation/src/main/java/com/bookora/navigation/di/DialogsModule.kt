package com.bookora.navigation.di

import com.bookora.core.essentials.dialogs.Dialogs
import com.bookora.navigation.base.impl.ComposeDialogs
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DialogsModule {

    @Binds
    fun bindDialogs(
        impl: ComposeDialogs
    ): Dialogs
}