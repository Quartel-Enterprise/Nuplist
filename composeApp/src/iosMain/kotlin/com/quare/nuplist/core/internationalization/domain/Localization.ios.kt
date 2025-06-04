package com.quare.nuplist.core.internationalization.domain

import com.quare.nuplist.core.option.SelectableOption
import platform.Foundation.NSLocale
import platform.Foundation.NSLocaleCountryCode
import platform.Foundation.NSLocaleLanguageCode
import platform.Foundation.NSUserDefaults
import platform.Foundation.currentLocale

actual class Localization {
    actual fun applyLanguage(language: SelectableOption.Language) {
        val languageCode = when (language) {
            SelectableOption.Language.PortugueseBrazil -> PORTUGUESE_BRAZIL
            SelectableOption.Language.EnglishUnitedStates -> ENGLISH_US
            SelectableOption.Language.System -> getSystemLocale().takeIf {
                it == PORTUGUESE_BRAZIL || it == ENGLISH_US
            } ?: ENGLISH_US
        }

        NSUserDefaults.standardUserDefaults.setObject(
            value = listOf(languageCode),
            forKey = "AppleLanguages"
        )
        NSUserDefaults.standardUserDefaults.synchronize()
    }

    private fun getSystemLocale(): String {
        val locale = NSLocale.currentLocale
        val language = locale.objectForKey(NSLocaleLanguageCode)?.toString() ?: "en"
        val country = locale.objectForKey(NSLocaleCountryCode)?.toString() ?: "US"
        return "$language-$country"
    }

    companion object {
        private const val PORTUGUESE_BRAZIL = "pt-BR"
        private const val ENGLISH_US = "en-US"
    }
}
