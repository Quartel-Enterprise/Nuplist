package com.quare.nuplist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.onClick
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.quare.nuplist.app.presentation.App
import com.quare.nuplist.di.initializeKoin

@OptIn(ExperimentalFoundationApi::class)
fun main() = application {
    initializeKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Nuplist",
    ) {

        App(
            getNavigationModifier = { onBack ->
                Modifier.onClick(
                    matcher = PointerMatcher.mouse(PointerButton.Back),
                    onClick = onBack,
                )
            }
        )
    }
}
