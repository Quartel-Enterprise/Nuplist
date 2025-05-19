package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.core.theme.ThemeOption

@Composable
fun ThemeMenu(
    currentTheme: ThemeOption,
    onThemeSelected: (ThemeOption) -> Unit,
    startSpacing: Int = 0,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        ThemeOption.entries.forEach { themeOption ->
            ThemeMenuItem(
                startSpacing = startSpacing,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable { onThemeSelected(themeOption) },
                themeOption = themeOption,
                isSelected = themeOption == currentTheme
            )
        }
    }
}
