package com.bookora.navigation.base.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.bookora.navigation.Route
import com.bookora.navigation.base.ExtendedNavGraphBuilder
import com.bookora.navigation.base.ExtendedNavStore
import com.bookora.navigation.dsl.ScreenScope
import kotlin.reflect.KClass

class ExtendedNavGraphBuilderImpl(
    private val navGraphBuilder: NavGraphBuilder,
    private val navStore: ExtendedNavStore
) : ExtendedNavGraphBuilder {
    override fun <T : Route> composable(
        routeClass: KClass<T>,
        configuration: ScreenScope.(T) -> Unit
    ) {
        navStore.registerConfiguration(routeClass, configuration)
        navGraphBuilder.composable(routeClass) { navEntry ->
            val route = navEntry.toRoute<T>(routeClass)
            navStore.Content(route, navEntry)
        }
    }
}