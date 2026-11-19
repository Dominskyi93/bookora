package com.bookora.navigation.routers

import com.bookora.core.essentials.entities.Id
import com.bookora.navigation.base.AppRouter
import com.bookora.features.main.presentation.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val appRouter: AppRouter
) : MainRouter {
    override fun navigateUp() {
        appRouter.goBack()
    }

    override fun navigateToChat(chatId: Id) {
//        appRouter.launch()
    }
}