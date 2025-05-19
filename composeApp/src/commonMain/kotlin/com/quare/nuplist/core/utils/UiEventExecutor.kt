package com.quare.nuplist.core.utils

interface UiEventExecutor<in T: Any> {
    fun dispatchUiEvent(uiEvent: T)
}
