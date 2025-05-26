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
import com.quare.nuplist.core.option.SelectableOption

@Composable
fun OptionMenu(
    options: List<SelectableOption>,
    currentOption: SelectableOption,
    onOptionSelected: (SelectableOption) -> Unit,
    startSpacing: Int = 0,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        options.forEach { option ->
            OptionMenuItem(
                startSpacing = startSpacing,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable { onOptionSelected(option) },
                option = option,
                isSelected = option == currentOption
            )
        }
    }
}
