package com.bookora.features.library.domain.usecases

import com.bookora.features.library.domain.GetBooksUseCase
import com.bookora.features.library.domain.entities.Book
import com.bookora.features.library.domain.repositories.BookRepository
import javax.inject.Inject

class GetBooksUseCaseImpl @Inject constructor(
    private val repository: BookRepository
) : GetBooksUseCase {
    override suspend fun invoke(): List<Book> {
        return repository.getBooks()
    }
}