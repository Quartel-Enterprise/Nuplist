package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import com.quare.nuplist.ui.theme_selector.presentation.toIcon
import com.quare.nuplist.ui.theme_selector.presentation.toName
import org.jetbrains.compose.resources.stringResource

@Composable
fun ThemeMenuItem(
    themeOption: ThemeOption,
    isSelected: Boolean,
    startSpacing: Int = 0,
    modifier: Modifier = Modifier,
) {
        val displayName = stringResource(themeOption.toName())
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalSpacer(startSpacing)
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                tint = if (isSelected) {
                    LocalContentColor.current
                } else {
                    Color.Transparent
                }
            )
            HorizontalSpacer(16)
            Icon(
                imageVector = themeOption.toIcon(),
                contentDescription = displayName
            )
            HorizontalSpacer(16)
            Text(text = displayName)
        }
}

@Composable
private fun getSurfaceColor(isSelected: Boolean): Color {
    return if (isSelected) {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
}
