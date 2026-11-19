package com.bookora.features.main.presentation

import com.bookora.core.essentials.entities.Id

interface MainRouter {
    fun navigateUp()
    fun navigateToChat(chatId: Id)
}