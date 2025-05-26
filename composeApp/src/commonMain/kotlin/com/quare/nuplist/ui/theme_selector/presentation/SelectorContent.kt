package com.quare.nuplist.ui.theme_selector.presentation

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiEvent
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiState
import com.quare.nuplist.ui.theme_selector.presentation.component.MenuAnimated
import com.quare.nuplist.ui.theme_selector.presentation.component.SelectorHeader

@Composable
fun SelectorContent(
    selectedOption: SelectableOption,
    modifier: Modifier = Modifier,
    options: List<SelectableOption>,
    state: SelectorUiState,
    onEvent: (SelectorUiEvent) -> Unit,
) {
    SelectorHeader(
        isMenuExpanded = state.isMenuExpanded,
        modifier = modifier.clickable {
            onEvent(SelectorUiEvent.ToggleMenu)
        },
        option = selectedOption,
    )

    MenuAnimated(
        state = state,
        onOptionSelected = {
            onEvent(SelectorUiEvent.Select(it))
        },
        options = options,
    )
}
