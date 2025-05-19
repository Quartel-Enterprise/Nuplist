package com.quare.nuplist.ui.theme_selector.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.ui.graphics.vector.ImageVector
import com.quare.nuplist.core.theme.ThemeOption
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.dark
import nuplist.composeapp.generated.resources.light
import nuplist.composeapp.generated.resources.system
import org.jetbrains.compose.resources.StringResource

internal fun ThemeOption.toName(): StringResource = when (this) {
    ThemeOption.LIGHT -> Res.string.light
    ThemeOption.DARK -> Res.string.dark
    ThemeOption.SYSTEM -> Res.string.system
}

internal fun ThemeOption.toIcon(): ImageVector = when (this) {
    ThemeOption.LIGHT -> Icons.Filled.LightMode
    ThemeOption.DARK -> Icons.Filled.DarkMode
    ThemeOption.SYSTEM -> Icons.Filled.Brightness6
}
