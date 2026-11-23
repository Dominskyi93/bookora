package com.bookora.features.profile.presentation

import com.bookora.core.essentials.entities.Id

interface ProfileRouter {
    fun navigateUp()
    fun navigateToChat(chatId: Id)
}