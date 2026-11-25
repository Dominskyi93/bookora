package com.bookora.glue.library.mappers

import com.bookora.data.books.entities.BookDto
import com.bookora.data.books.entities.TrendingResponse
import com.bookora.features.library.domain.entities.Book

fun BookDto.toDomain(): Book = Book(
    key = key,
    title = title,
    authorName = author_name,
    firstPublishYear = 0,
    coverI = cover_i ?: 0
)

fun TrendingResponse.toDomain(): List<Book> =
    works.map { it.toDomain() }