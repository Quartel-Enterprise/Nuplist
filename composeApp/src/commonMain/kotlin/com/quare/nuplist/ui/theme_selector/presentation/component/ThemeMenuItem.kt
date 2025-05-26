package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import com.quare.nuplist.core.option.SelectableOption
import org.jetbrains.compose.resources.stringResource

@Composable
fun OptionMenuItem(
    option: SelectableOption,
    isSelected: Boolean,
    startSpacing: Int = 0,
    modifier: Modifier = Modifier,
) {
        val displayName = stringResource(option.name)
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
            option.icon?.let {
                HorizontalSpacer(16)
                Icon(
                    imageVector = it,
                    contentDescription = displayName
                )
            }
            HorizontalSpacer(16)
            Text(text = displayName)
        }
}
