package com.quare.nuplist.core.internationalization.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.quare.nuplist.core.internationalization.domain.Language
import com.quare.nuplist.core.internationalization.domain.Localization
import dev.burnoo.compose.remembersetting.rememberStringSetting
import org.koin.compose.koinInject

@Composable
fun InitializeLanguage() {
    val localization = koinInject<Localization>()
    val languageIso by rememberStringSetting(
        key = "savedLanguageIso",
        defaultValue = Language.English.iso,
    )
    LaunchedEffect(Unit) {
        localization.applyLanguage(languageIso)
    }
}
