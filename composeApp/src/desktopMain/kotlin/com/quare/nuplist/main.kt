package com.quare.nuplist

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.quare.nuplist.app.presentation.App
import com.quare.nuplist.di.initializeKoin

fun main() = application {
    initializeKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Nuplist",
    ) {
        App()
    }
}
