package com.quare.nuplist.ui.dialog.profile.presentation.model

import com.quare.nuplist.core.option.SelectableOption

sealed interface ProfileDialogUiAction {
    data class OpenUri(val uri: String) : ProfileDialogUiAction
    data class ChangeOption(val option: SelectableOption) : ProfileDialogUiAction
}
