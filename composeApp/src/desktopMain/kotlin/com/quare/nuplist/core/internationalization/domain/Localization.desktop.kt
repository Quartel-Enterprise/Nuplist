package com.quare.nuplist.core.internationalization.domain

import java.util.Locale

actual class Localization {
    actual fun applyLanguage(iso: String) {
        val locale = Locale.Builder()
            .setLanguage(iso)
            .build()
        Locale.setDefault(locale)
    }
}
