package com.bookora.data

import com.bookora.data.books.entities.BookDto

interface BooksDataRepository {
    suspend fun getRecommendedBooks(): List<BookDto>
}