package com.quare.nuplist.core.option

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalThemeOption: ProvidableCompositionLocal<SelectableOption.Theme> = compositionLocalOf {
    SelectableOption.Theme.System
}

val LocalLanguageOption: ProvidableCompositionLocal<SelectableOption.Language> =
    compositionLocalOf {
        SelectableOption.Language.System
    }
