package com.quare.nuplist.ui.dialog.profile.presentation.model

import com.quare.nuplist.core.theme.ThemeOption

sealed interface ProfileDialogUiAction {
    data class OpenUri(val uri: String) : ProfileDialogUiAction
    data class ChangeTheme(val theme: ThemeOption) : ProfileDialogUiAction
}
