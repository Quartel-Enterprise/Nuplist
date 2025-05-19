package com.quare.nuplist.ui.theme_selector.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.core.utils.UiEventExecutor
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiEvent
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ThemeSelectorViewModel(
    themeSelected: ThemeOption,
    private val onThemeChange: (ThemeOption) -> Unit,
) : ViewModel(), UiEventExecutor<ThemeSelectorUiEvent> {

    private val _state: MutableStateFlow<ThemeSelectorUiState> = MutableStateFlow(
        ThemeSelectorUiState(
            themeSelected = themeSelected,
            isMenuExpanded = false
        )
    )

    val state: StateFlow<ThemeSelectorUiState> = _state

    override fun dispatchUiEvent(uiEvent: ThemeSelectorUiEvent) {
        when (uiEvent) {
            is ThemeSelectorUiEvent.SelectTheme -> {
                if (state.value.themeSelected == uiEvent.theme) return
                _state.update {
                    it.copy(
                        themeSelected = uiEvent.theme,
                    )
                }
                onThemeChange(uiEvent.theme)
            }

            ThemeSelectorUiEvent.ToggleMenu -> _state.update {
                it.copy(
                    isMenuExpanded = !it.isMenuExpanded
                )
            }

            ThemeSelectorUiEvent.CloseMenu -> _state.update {
                it.copy(
                    isMenuExpanded = false
                )
            }
        }
    }
}
