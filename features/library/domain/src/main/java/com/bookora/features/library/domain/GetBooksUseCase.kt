package com.bookora.features.library.domain

import com.bookora.features.library.domain.entities.Book

interface GetBooksUseCase {
    suspend operator fun invoke(): List<Book>
}