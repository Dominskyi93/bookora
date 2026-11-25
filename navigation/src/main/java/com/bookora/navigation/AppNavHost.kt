@file:Suppress("UNCHECKED_CAST")

package com.bookora.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.bookora.navigation.base.ExtendedNavGraphBuilder
import com.bookora.navigation.base.impl.ComposeDialogs
import com.bookora.navigation.base.impl.ExtendedNavGraphBuilderImpl
import com.bookora.navigation.base.impl.NavComponentAppRouter

@Composable
fun AppNavHost(
    dialogs: ComposeDialogs,
    modifier: Modifier = Modifier,
    startDestination: Route = MainRoute,
    navGraphBuilder: ExtendedNavGraphBuilder.() -> Unit = {}
) {
    val backStack = rememberNavBackStack(startDestination)
            as NavBackStack<Route>

    val router = NavComponentAppRouter.get()

    SideEffect {
        router.setBackStack(backStack)
    }

    Surface(
        Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        NavDisplay(
            backStack = backStack,
            modifier = modifier,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                ExtendedNavGraphBuilderImpl(
                    origin = this,
                    router = router
                ).apply {
                    buildAppNavGraph()
                    navGraphBuilder()
                }
                dialogs.Renderer()
            }
        )
    }
}