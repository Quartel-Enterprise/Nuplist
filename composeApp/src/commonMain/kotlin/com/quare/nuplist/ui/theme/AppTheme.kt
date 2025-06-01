package com.quare.nuplist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.quare.nuplist.core.option.LocalThemeOption
import com.quare.nuplist.ui.theme.color.darkScheme
import com.quare.nuplist.ui.theme.color.lightScheme
import com.quare.nuplist.core.option.SelectableOption

@Composable
fun AppTheme(
    getSpecificColors: @Composable ((Boolean) -> ColorScheme?)? = null,
    content: @Composable () -> Unit,
) {
    val isDarkTheme = isAppInDarkTheme()
    MaterialTheme(
        colorScheme = getSpecificColors?.invoke(isDarkTheme) ?: getColorScheme(isDarkTheme),
        content = content
    )
}

@Composable
fun isAppInDarkTheme(): Boolean = when (LocalThemeOption.current) {
    SelectableOption.Theme.Dark -> true
    SelectableOption.Theme.Light -> false
    SelectableOption.Theme.System -> isSystemInDarkTheme()
}

@Composable
private fun getColorScheme(isDarkTheme: Boolean): ColorScheme {
    return when {
        isDarkTheme -> darkScheme
        else -> lightScheme
    }
}
