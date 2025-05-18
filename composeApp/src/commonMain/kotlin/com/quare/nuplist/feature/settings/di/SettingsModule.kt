package com.quare.nuplist.feature.settings.di

import com.quare.nuplist.feature.settings.presentation.SettingsViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

val settingsModule = module {
    viewModelOf(::SettingsViewModel)
}
