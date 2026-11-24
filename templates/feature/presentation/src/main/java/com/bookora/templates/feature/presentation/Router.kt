package com.bookora.templates.feature.presentation

import com.bookora.core.essentials.entities.Id

interface Router {
    fun navigateUp()
    fun navigateToChat(chatId: Id)
}