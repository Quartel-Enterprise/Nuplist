package com.quare.nuplist.ui.dialog.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiAction
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiEvent
import com.quare.nuplist.ui.theme_selector.domain.SaveSelectableOptionUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ProfileDialogViewModel(
    private val saveSelectableOption: SaveSelectableOptionUseCase,
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<ProfileDialogUiAction> = MutableSharedFlow()
    val uiAction: SharedFlow<ProfileDialogUiAction> = _uiAction

    fun dispatchUiEvent(uiEvent: ProfileDialogUiEvent) {
        when (uiEvent) {
            is ProfileDialogUiEvent.LinkClick -> TODO()
            is ProfileDialogUiEvent.SelectOption -> setOption(uiEvent.option)
        }
    }

    private fun setOption(option: SelectableOption) {
        viewModelScope.launch {
            _uiAction.emit(ProfileDialogUiAction.ChangeOption(option))
            saveSelectableOption(option)
        }
    }
}
