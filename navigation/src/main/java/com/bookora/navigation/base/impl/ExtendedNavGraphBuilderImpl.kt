package com.bookora.navigation.base.impl

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation3.runtime.EntryProviderScope
import com.bookora.navigation.AppScreenScaffold
import com.bookora.navigation.Route
import com.bookora.navigation.base.ExtendedNavGraphBuilder
import com.bookora.navigation.dsl.ScreenScope
import kotlin.reflect.KClass

class ExtendedNavGraphBuilderImpl(
    private val router: NavComponentAppRouter,
    private val origin: EntryProviderScope<Route>
) : ExtendedNavGraphBuilder {
    override fun <T : Route> composable(
        routeClass: KClass<T>,
        configuration: ScreenScope.(T) -> Unit
    ) {
        origin.addEntryProvider(routeClass) { route ->
            val context = LocalContext.current
            val coroutineScope = rememberCoroutineScope()
            val viewModelStoreOwner = requireNotNull(LocalViewModelStoreOwner.current)
            viewModelStoreOwner as HasDefaultViewModelProviderFactory
            val nav3ScreenScope: Nav3ScreenScope = remember(
                context,
                coroutineScope,
                viewModelStoreOwner,
                route
            ) {
                Nav3ScreenScope(
                    context = context,
                    coroutineScope = coroutineScope,
                    viewModelStoreOwner = viewModelStoreOwner,
                    defaultsProvider = viewModelStoreOwner
                ).apply {
                    configuration(this, route)
                }
            }
            AppScreenScaffold(
                navigationBar = nav3ScreenScope.navigationBar,
                showBackButton = !router.isRoot(route),
                toolbar = nav3ScreenScope.toolbar,
                onBackPressed = router::goBack,
                modifier = Modifier.fillMaxSize(),
            ) { nav3ScreenScope.Content() }
        }
    }
}