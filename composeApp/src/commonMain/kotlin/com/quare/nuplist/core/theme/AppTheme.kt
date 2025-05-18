package com.quare.nuplist.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.quare.nuplist.core.theme.color.lightScheme
import com.quare.nuplist.core.theme.color.darkScheme

@Composable
fun AppTheme(
    specificColors: ColorScheme? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = specificColors ?: getColorScheme(),
        content = content
    )
}

@Composable
private fun getColorScheme(): ColorScheme {
    val isDarkTheme = isSystemInDarkTheme()
    return when {
        isDarkTheme -> darkScheme
        else -> lightScheme
    }
}
