package com.bookora.navigation.base

import com.bookora.navigation.MainRoute
import com.bookora.navigation.Route

interface AppRouter {
    fun launch(route: Route)
    fun restart(route: Route)
    fun goBack()
    fun replace(route: Route)
}

fun AppRouter.launchMainFlow() = restart(MainRoute)
