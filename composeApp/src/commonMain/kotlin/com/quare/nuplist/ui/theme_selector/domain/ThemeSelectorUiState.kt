package com.quare.nuplist.ui.theme_selector.domain

import com.quare.nuplist.core.theme.ThemeOption

data class ThemeSelectorUiState(
    val themeSelected: ThemeOption,
    val isMenuExpanded: Boolean
)
