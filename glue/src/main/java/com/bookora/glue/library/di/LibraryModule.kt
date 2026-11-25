package com.bookora.glue.library.di

import com.bookora.features.library.domain.repositories.BookRepository
import com.bookora.glue.library.LibraryGetBooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface LibraryModule {

    @Binds
    fun bindLibraryRepository(
        impl: LibraryGetBooksRepository
    ): BookRepository

}