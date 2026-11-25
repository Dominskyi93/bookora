package com.bookora.data.books.di

import com.bookora.data.BooksDataRepository
import com.bookora.data.books.BooksDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BooksDataModule {

    @Binds
    @Singleton
    abstract fun bindBooksRepository(
        impl: BooksDataRepositoryImpl
    ): BooksDataRepository
}