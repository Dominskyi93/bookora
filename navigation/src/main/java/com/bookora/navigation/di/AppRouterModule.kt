package com.bookora.navigation.di

import com.bookora.navigation.base.AppRouter
import com.bookora.navigation.base.impl.NavComponentAppRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AppRouterModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindAppRouter(
        impl: NavComponentAppRouter
    ): AppRouter
}