package com.quare.nuplist.ui.dialog.profile.presentation.model

import com.quare.nuplist.core.internationalization.domain.Language
import com.quare.nuplist.core.theme.ThemeOption

sealed interface ProfileDialogUiEvent {
    data class SelectTheme(val theme: ThemeOption) : ProfileDialogUiEvent
    data class SelectLanguage(val language: Language) : ProfileDialogUiEvent
}
