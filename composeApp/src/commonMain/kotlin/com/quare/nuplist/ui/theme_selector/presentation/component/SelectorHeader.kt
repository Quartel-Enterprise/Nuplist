package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import org.jetbrains.compose.resources.stringResource

@Composable
fun SelectorHeader(
    option: SelectableOption,
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
            val optionText = stringResource(option.menuName)
            Icon(
                imageVector = option.menuIcon,
                contentDescription = optionText
            )
            HorizontalSpacer(8)
            Text(optionText)
        }
        ThemeMenuArrowIcon(isMenuExpanded)
    }
}
