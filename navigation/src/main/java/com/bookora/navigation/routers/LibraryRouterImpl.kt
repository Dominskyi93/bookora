package com.bookora.navigation.routers

import com.bookora.core.essentials.entities.Id
import com.bookora.features.library.presentation.LibraryRouter
import com.bookora.navigation.base.AppRouter
import javax.inject.Inject

class LibraryRouterImpl @Inject constructor(
    private val appRouter: AppRouter
) : LibraryRouter {
    override fun navigateUp() {
        appRouter.goBack()
    }

    override fun navigateToChat(chatId: Id) {
//        appRouter.launch()
    }
}