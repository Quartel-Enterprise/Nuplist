package com.quare.nuplist.core.internationalization.domain

import android.content.Context
import android.os.LocaleList
import java.util.*

actual class Localization(
    private val context: Context
) {
    actual fun applyLanguage(iso: String) {
        val locale = Locale(iso)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocales(LocaleList(locale))
    }
}
