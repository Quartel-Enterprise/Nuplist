package com.quare.nuplist.ui.dialog.profile.presentation.model

import com.quare.nuplist.core.option.SelectableOption

sealed interface ProfileDialogUiEvent {
    data class SelectOption(val option: SelectableOption) : ProfileDialogUiEvent
    data class LinkClick(val link: WebLink) : ProfileDialogUiEvent
}
