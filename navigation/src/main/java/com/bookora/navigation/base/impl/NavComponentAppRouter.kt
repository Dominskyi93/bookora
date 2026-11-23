package com.bookora.navigation.base.impl

import androidx.navigation3.runtime.NavBackStack
import com.bookora.navigation.Route
import com.bookora.navigation.base.AppRouter

class NavComponentAppRouter(
    private val backStack: NavBackStack<Route>
) : AppRouter {

    fun isRoot(route: Route): Boolean {
        return backStack.indexOf(route) == 0
    }

    override fun launch(route: Route) {
        backStack.add(route)
    }

    override fun restart(route: Route) {
        backStack.clear()
        launch(route)
    }

    override fun goBack() {
        backStack.removeLastOrNull()
    }

    override fun replace(route: Route) {
        goBack()
        backStack.add(route)
    }
}