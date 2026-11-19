package com.bookora.navigation.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.bookora.navigation.Route
import com.bookora.navigation.dsl.ConfiguredScreen
import com.bookora.navigation.dsl.ScreenScope
import kotlin.reflect.KClass

interface ExtendedNavStore {

    val screen: ConfiguredScreen

    fun onBackStackChanged(backStack: List<NavBackStackEntry>)

    fun <T : Route> registerConfiguration(
        routeClass: KClass<T>,
        content: ScreenScope.(T) -> Unit
    )

    @Composable
    fun <T : Route> Content(route: T, navEntry: NavBackStackEntry)
}