package com.quare.nuplist.core.internationalization.domain

import platform.Foundation.NSUserDefaults

actual class Localization {
    actual fun applyLanguage(iso: String) {
        NSUserDefaults.standardUserDefaults.setObject(
            value = arrayListOf(iso),
            forKey = "AppleLanguages",
        )
    }
}
