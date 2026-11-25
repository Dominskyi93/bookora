package com.bookora.features.library.presentation

import androidx.lifecycle.viewModelScope
import com.bookora.core.presentation.base.AbstractViewModel
import com.bookora.features.library.domain.GetBooksUseCase
import com.bookora.features.library.domain.entities.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryVM @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val appRouter: LibraryRouter,
) : AbstractViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading
        .onStart {
            getBooks()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books.asStateFlow()

    fun getBooks() {
        viewModelScope.launch {
            _isLoading.update { true }

            try {
                _books.value = getBooksUseCase()
            } finally {
                _isLoading.update { false }
            }
        }
    }
}