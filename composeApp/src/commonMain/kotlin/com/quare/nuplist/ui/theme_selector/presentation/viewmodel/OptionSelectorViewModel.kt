package com.quare.nuplist.ui.theme_selector.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.quare.nuplist.core.utils.UiEventExecutor
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiEvent
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class OptionSelectorViewModel(
    optionSelected: SelectableOption,
    private val onOptionSelected: (SelectableOption) -> Unit,
) : ViewModel(), UiEventExecutor<SelectorUiEvent> {

    private val _state: MutableStateFlow<SelectorUiState> = MutableStateFlow(
        SelectorUiState(
            optionSelected = optionSelected,
            isMenuExpanded = false
        )
    )

    val state: StateFlow<SelectorUiState> = _state

    override fun dispatchUiEvent(uiEvent: SelectorUiEvent) {
        when (uiEvent) {
            is SelectorUiEvent.Select -> {
                if (state.value.optionSelected == uiEvent.option) return
                _state.update {
                    it.copy(
                        optionSelected = uiEvent.option,
                    )
                }
                onOptionSelected(uiEvent.option)
            }

            SelectorUiEvent.ToggleMenu -> _state.update {
                it.copy(
                    isMenuExpanded = !it.isMenuExpanded
                )
            }

            SelectorUiEvent.CloseMenu -> _state.update {
                it.copy(
                    isMenuExpanded = false
                )
            }
        }
    }
}
