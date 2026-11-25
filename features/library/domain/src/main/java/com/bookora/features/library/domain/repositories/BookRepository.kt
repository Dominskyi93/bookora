package com.bookora.features.library.domain.repositories

import com.bookora.features.library.domain.entities.Book

interface BookRepository {
    suspend fun getBooks(): List<Book>
}
