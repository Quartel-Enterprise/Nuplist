package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.stringResource

@Composable
fun ThemeSelectorHeader(
    isMenuExpanded: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val themeText = stringResource(Res.string.theme)
            Icon(
                imageVector = Icons.Default.Brush,
                contentDescription = themeText
            )
            HorizontalSpacer(8)
            Text(themeText)
        }
        ThemeMenuArrowIcon(isMenuExpanded)
    }
}
