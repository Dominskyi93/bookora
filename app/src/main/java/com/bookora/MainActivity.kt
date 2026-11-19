package com.bookora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bookora.core.common.android.AndroidExceptionHandler
import com.bookora.navigation.AppNavHost
import com.bookora.navigation.base.impl.ComposeDialogs
import com.bookora.ui.theme.BookoraTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var exceptionHandler: AndroidExceptionHandler

    @Inject
    lateinit var dialogs: ComposeDialogs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookoraTheme {
                BookoraApp(dialogs)
                exceptionHandler.ErrorDialog()
            }
        }
    }
}

//@PreviewScreenSizes
@Composable
fun BookoraApp(dialogs: ComposeDialogs) {
    AppNavHost(dialogs = dialogs, modifier = Modifier.fillMaxSize())
}