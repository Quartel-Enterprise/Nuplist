package com.quare.nuplist.core.internationalization.domain

import com.quare.nuplist.core.option.SelectableOption
import java.util.*

actual class Localization {
    actual fun applyLanguage(language: SelectableOption.Language) {
        val portugueseBrazilLocale = Locale.Builder()
            .setLanguage("pt")
            .setRegion("BR")
            .build()

        val englishUnitedStatesLocale = Locale.Builder()
            .setLanguage("en")
            .setRegion("US")
            .build()

        val locale = when (language) {
            SelectableOption.Language.PortugueseBrazil -> portugueseBrazilLocale
            SelectableOption.Language.EnglishUnitedStates -> englishUnitedStatesLocale
            SelectableOption.Language.System -> Locale.getDefault()
        }

        Locale.setDefault(locale)
    }
}
