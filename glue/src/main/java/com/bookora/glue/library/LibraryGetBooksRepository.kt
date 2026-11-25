package com.bookora.glue.library

import com.bookora.data.BooksDataRepository
import com.bookora.features.library.domain.entities.Book
import com.bookora.features.library.domain.repositories.BookRepository
import com.bookora.glue.library.mappers.toDomain
import javax.inject.Inject

internal class LibraryGetBooksRepository @Inject constructor(
    private val booksDataRepository: BooksDataRepository
) : BookRepository {

    override suspend fun getBooks(): List<Book> {
        return booksDataRepository.getRecommendedBooks()
            .map { it.toDomain() }
    }
}