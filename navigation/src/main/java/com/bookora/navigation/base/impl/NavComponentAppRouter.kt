package com.bookora.navigation.base.impl

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.bookora.navigation.Route
import com.bookora.navigation.base.AppRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NavComponentAppRouter @Inject constructor() : AppRouter {

    private var backStack: NavBackStack<Route>? = null

    fun setBackStack(backStack: NavBackStack<Route>?) {
        this.backStack = backStack
    }

    fun isRoot(route: Route): Boolean {
        return backStack?.indexOf(route) == 0
    }

    override fun launch(route: Route) {
        backStack?.add(route)
    }

    override fun restart(route: Route) {
        backStack?.apply {
            clear()
            add(route)
        }
    }

    override fun goBack() {
        backStack?.removeLastOrNull()
    }

    override fun replace(route: Route) {
        backStack?.apply {
            removeLastOrNull()
            add(route)
        }
    }

    @HiltViewModel
    class VM @Inject constructor(
        val appRouter: NavComponentAppRouter
    ) : ViewModel()

    companion object {
        @Composable
        fun get(): NavComponentAppRouter {
            return hiltViewModel<VM>().appRouter
        }
    }
}