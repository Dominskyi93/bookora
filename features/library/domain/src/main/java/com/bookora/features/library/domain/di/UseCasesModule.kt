package com.bookora.features.library.domain.di

import com.bookora.features.library.domain.GetBooksUseCase
import com.bookora.features.library.domain.usecases.GetBooksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface UseCasesModule {

    @Binds
    fun bindGetBooksUseCase(
        impl: GetBooksUseCaseImpl
    ): GetBooksUseCase
}