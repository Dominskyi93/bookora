package com.bookora.navigation.di

import com.bookora.features.library.presentation.LibraryRouter
import com.bookora.features.main.presentation.MainRouter
import com.bookora.features.profile.presentation.ProfileRouter
import com.bookora.navigation.routers.LibraryRouterImpl
import com.bookora.navigation.routers.MainRouterImpl
import com.bookora.navigation.routers.ProfileRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RoutersModule {

    @Binds
    fun bindMainRouter(
        impl: MainRouterImpl
    ): MainRouter

    @Binds
    fun bindProfileRouter(
        impl: ProfileRouterImpl
    ): ProfileRouter

    @Binds
    fun bindLibraryRouter(
        impl: LibraryRouterImpl
    ): LibraryRouter

}