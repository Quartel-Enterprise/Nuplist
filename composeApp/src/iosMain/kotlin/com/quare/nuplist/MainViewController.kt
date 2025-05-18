package com.quare.nuplist

import androidx.compose.ui.window.ComposeUIViewController
import com.quare.nuplist.di.initializeKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = { initializeKoin() }
) {
    App()
}
