package com.quare.nuplist.core.theme

import androidx.compose.runtime.compositionLocalOf

val LocalThemeOption = compositionLocalOf {
    ThemeOption.SYSTEM
}

val LocalThemeChanged = compositionLocalOf<(ThemeOption) -> Unit> {
    error("No theme change callback provided")
}

enum class ThemeOption {
    LIGHT,
    DARK,
    SYSTEM,
}
