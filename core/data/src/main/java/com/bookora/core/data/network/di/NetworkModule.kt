package com.bookora.core.data.network.di

import com.bookora.core.data.network.NetworkConfig
import com.bookora.core.data.network.clients.createDefaultOkHttpClient
import com.bookora.core.data.network.clients.createDefaultRetrofit
import com.bookora.core.data.network.converters.createDefaultJson
import com.bookora.core.data.network.interceptors.createHttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        networkConfig: NetworkConfig,
        okHttpClient: OkHttpClient,
        json: Json
    ): Retrofit {
        return createDefaultRetrofit(
            baseUrl = networkConfig.baseUrl,
            client = okHttpClient,
            json = json
        )
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        networkConfig: NetworkConfig
    ): OkHttpClient {
        return createDefaultOkHttpClient(
            timeout = networkConfig.timeout,
            interceptors = listOf(
                createHttpLoggingInterceptor(networkConfig.isDebug),
            )
        )
    }

    @Provides
    @Singleton
    fun provideDefaultJson(networkConfig: NetworkConfig): Json {
        return createDefaultJson(networkConfig.isDebug)
    }
}