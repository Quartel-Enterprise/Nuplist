package com.quare.nuplist.app.domain

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.quare.nuplist.core.option.PreferencesKeys
import com.quare.nuplist.core.option.SelectableOption
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetLanguageOptionUseCase(
    private val dataStore: DataStore<Preferences>,
) {
    suspend operator fun invoke(): SelectableOption.Language = dataStore.data.map { value ->
        val language = value[stringPreferencesKey(PreferencesKeys.LANGUAGE)]
        when (language) {
            "pt_BR" -> SelectableOption.Language.PortugueseBrazil
            "en_US" -> SelectableOption.Language.EnglishUnitedStates
            else -> SelectableOption.Language.System
        }
    }.first()
}
