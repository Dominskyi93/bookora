package com.bookora.core.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

abstract class AbstractViewModel : ViewModel() {

    val coroutineScope: CoroutineScope = viewModelScope

}