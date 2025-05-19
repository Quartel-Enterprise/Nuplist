package com.quare.nuplist.ui.theme_selector.domain

import com.quare.nuplist.core.theme.ThemeOption

sealed interface ThemeSelectorUiEvent {
    data object ToggleMenu : ThemeSelectorUiEvent
    data object CloseMenu : ThemeSelectorUiEvent
    data class SelectTheme(val theme: ThemeOption) : ThemeSelectorUiEvent
}
