package com.quare.nuplist.ui.theme_selector.domain

import com.quare.nuplist.core.option.SelectableOption

data class SelectorUiState(
    val optionSelected: SelectableOption,
    val isMenuExpanded: Boolean
)
