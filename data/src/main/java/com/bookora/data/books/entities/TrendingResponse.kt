package com.bookora.data.books.entities

import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse(
    val works: List<BookDto>
)

@Serializable
data class BookDto(
    val key: String,
    val title: String,
    val author_name: List<String> = emptyList(),
    val cover_i: Int? = null
)