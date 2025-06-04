package com.quare.nuplist.core.internationalization.domain

import android.content.Context
import android.content.res.Configuration
import android.os.LocaleList
import com.quare.nuplist.core.option.SelectableOption
import java.util.*

actual class Localization(
    private val context: Context,
) {
    actual fun applyLanguage(language: SelectableOption.Language) {
        val portugueseBrazilLocale = Locale("pt", "BR")
        val englishUnitedStatesLocale = Locale("en", "US")
        val locale = when (language) {
            SelectableOption.Language.PortugueseBrazil -> portugueseBrazilLocale
            SelectableOption.Language.EnglishUnitedStates -> englishUnitedStatesLocale
            SelectableOption.Language.System -> LocaleList.getDefault()[0]
        }

        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocales(LocaleList(locale))
    }
}
