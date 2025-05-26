package com.quare.nuplist.ui.theme_selector.domain

import com.quare.nuplist.core.option.SelectableOption

sealed interface SelectorUiEvent {
    data object ToggleMenu : SelectorUiEvent
    data object CloseMenu : SelectorUiEvent
    data class Select(val option: SelectableOption) : SelectorUiEvent
}
