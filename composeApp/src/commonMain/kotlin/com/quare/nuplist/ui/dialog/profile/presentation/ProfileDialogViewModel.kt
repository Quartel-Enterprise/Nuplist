package com.quare.nuplist.ui.dialog.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.internationalization.domain.Language
import com.quare.nuplist.core.theme.ThemeOption
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
            is ProfileDialogUiEvent.SelectTheme -> setThemeOption(uiEvent.theme)
            is ProfileDialogUiEvent.SelectLanguage -> TODO()
        }
    }

    private fun setThemeOption(theme: ThemeOption) {
        viewModelScope.launch {
//            useCases.setThemeOption(theme)
            _uiAction.emit(ProfileDialogUiAction.ChangeTheme(theme))
        }
    }

    private fun setLanguage(language: Language) {
        viewModelScope.launch {
//            useCases.setLanguage(language)
        }
    }
}
