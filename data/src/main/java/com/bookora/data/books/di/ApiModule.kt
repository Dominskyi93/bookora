package com.bookora.data.books.di

import com.bookora.data.books.remote.OpenLibraryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideOpenLibraryApi(
        retrofit: Retrofit
    ): OpenLibraryApi {
        return retrofit.create(OpenLibraryApi::class.java)
    }
}