package com.bookora.navigation.base

import com.bookora.navigation.Route
import com.bookora.navigation.dsl.ScreenScope
import kotlin.reflect.KClass

interface ExtendedNavGraphBuilder {
    fun <T : Route> composable(
        routeClass: KClass<T>,
        configuration: ScreenScope.(T) -> Unit
    )
}

inline fun <reified T : Route> ExtendedNavGraphBuilder.composable(
    noinline configuration: ScreenScope.(T) -> Unit
) = composable(T::class, configuration)