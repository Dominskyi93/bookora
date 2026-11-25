package com.bookora.data.books

import com.bookora.data.BooksDataRepository
import com.bookora.data.books.entities.BookDto
import com.bookora.data.books.remote.OpenLibraryApi
import javax.inject.Inject

class BooksDataRepositoryImpl @Inject constructor(
    private val api: OpenLibraryApi
) : BooksDataRepository {

    override suspend fun getRecommendedBooks(): List<BookDto> {
        return api.getRecommendedBooks().works
    }
}