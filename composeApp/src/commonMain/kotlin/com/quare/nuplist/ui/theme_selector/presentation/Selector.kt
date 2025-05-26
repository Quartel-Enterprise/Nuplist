package com.quare.nuplist.ui.theme_selector.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiEvent
import com.quare.nuplist.ui.theme_selector.presentation.viewmodel.OptionSelectorViewModel
import com.quare.nuplist.ui.theme_selector.presentation.viewmodel.optionSelectorViewModel

@Composable
fun Selector(
    options: List<SelectableOption>,
    currentOption: SelectableOption,
    onOptionChange: (SelectableOption) -> Unit,
    modifier: Modifier = Modifier,
    viewmodel: OptionSelectorViewModel = optionSelectorViewModel(
        optionSelected = currentOption,
        onOptionChange = onOptionChange,
    ),
) {
    val onEvent = viewmodel::dispatchUiEvent
    val state by viewmodel.state.collectAsState()

    LaunchedEffect(currentOption) {
        onEvent(SelectorUiEvent.Select(currentOption))
    }

    SelectorContent(
        modifier = modifier,
        options = options,
        state = state,
        onEvent = onEvent,
        selectedOption = currentOption,
    )

    DisposableEffect(Unit) {
        onDispose {
            onEvent(SelectorUiEvent.CloseMenu)
        }
    }
}
