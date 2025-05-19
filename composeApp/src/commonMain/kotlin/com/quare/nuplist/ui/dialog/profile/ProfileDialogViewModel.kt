package com.quare.nuplist.ui.dialog.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogState
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogUiAction
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogUiEvent
import com.quare.nuplist.ui.dialog.profile.model.WebLink
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileDialogViewModel: ViewModel() {

    private val _state: MutableStateFlow<ProfileDialogState?> = MutableStateFlow(
        null
    )

    val state: StateFlow<ProfileDialogState?> = _state

    private val _uiAction: MutableSharedFlow<ProfileDialogUiAction> = MutableSharedFlow()
    val uiAction: SharedFlow<ProfileDialogUiAction> = _uiAction

    fun dispatchUiEvent(uiEvent: ProfileDialogUiEvent) {
        when (uiEvent) {
            is ProfileDialogUiEvent.SelectTheme -> setThemeOption(uiEvent.theme)
            is ProfileDialogUiEvent.LinkClick -> goToLink(uiEvent.webLink)
        }
    }

    private fun goToLink(webLink: WebLink) {
        viewModelScope.launch {
//            _uiAction.emit(ProfileDialogUiAction.OpenUri(useCases.getProfileDialogLink(webLink)))
        }
    }

    private fun setThemeOption(theme: ThemeOption) {
        viewModelScope.launch {
//            useCases.setThemeOption(theme)
            _uiAction.emit(ProfileDialogUiAction.ChangeTheme(theme))
        }
    }
}
