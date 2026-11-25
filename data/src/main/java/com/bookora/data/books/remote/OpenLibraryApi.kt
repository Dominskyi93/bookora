package com.bookora.data.books.remote

import com.bookora.data.books.entities.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {

    @GET("trending/weekly.json")
    suspend fun getRecommendedBooks(
        @Query("limit") limit: Int = 20
    ): TrendingResponse
}