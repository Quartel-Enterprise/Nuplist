package com.quare.nuplist.ui.dialog.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.internationalization.domain.Language
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiAction
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ProfileDialogViewModel: ViewModel() {

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
//            useCases.setThemeOption(theme)
            _uiAction.emit(ProfileDialogUiAction.ChangeOption(option))
        }
    }

    private fun setLanguage(language: Language) {
        viewModelScope.launch {
//            useCases.setLanguage(language)
        }
    }
}
