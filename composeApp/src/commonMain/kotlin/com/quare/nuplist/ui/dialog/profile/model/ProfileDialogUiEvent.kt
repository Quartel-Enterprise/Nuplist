package com.quare.nuplist.ui.dialog.profile.model

import com.quare.nuplist.core.theme.ThemeOption

sealed interface ProfileDialogUiEvent {
    data class SelectTheme(val theme: ThemeOption) : ProfileDialogUiEvent
    data class LinkClick(val webLink: WebLink) : ProfileDialogUiEvent
}
