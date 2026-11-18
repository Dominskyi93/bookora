package com.bookora.navigation.dsl

interface ConfiguredScreen {
    val toolbar: ScreenToolbar

    val navigationBar: ScreenNavigationBar

    val backHandler: ScreenBackHandler

    data object Empty : ConfiguredScreen {
        override val toolbar = ScreenToolbar.Hidden
        override val navigationBar = ScreenNavigationBar.Hidden
        override val backHandler = ScreenBackHandler.Default
    }
}