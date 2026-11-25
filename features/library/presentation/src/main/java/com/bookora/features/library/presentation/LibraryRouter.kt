package com.bookora.features.library.presentation

import com.bookora.core.essentials.entities.Id

interface LibraryRouter {
    fun navigateUp()
    fun navigateToChat(chatId: Id)
}