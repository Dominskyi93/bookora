package com.bookora.navigation.routers

import com.bookora.core.essentials.entities.Id
import com.bookora.features.profile.presentation.ProfileRouter
import com.bookora.navigation.base.AppRouter
import javax.inject.Inject

class ProfileRouterImpl @Inject constructor(
    private val appRouter: AppRouter
) : ProfileRouter {
    override fun navigateUp() {
        appRouter.goBack()
    }

    override fun navigateToChat(chatId: Id) {
//        appRouter.launch()
    }
}