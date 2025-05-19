package com.quare.nuplist.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.quare.nuplist.core.theme.color.darkScheme
import com.quare.nuplist.core.theme.color.lightScheme

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
    ThemeOption.LIGHT -> false
    ThemeOption.DARK -> true
    ThemeOption.SYSTEM -> isSystemInDarkTheme()
}

@Composable
private fun getColorScheme(isDarkTheme: Boolean): ColorScheme {
    return when {
        isDarkTheme -> darkScheme
        else -> lightScheme
    }
}
