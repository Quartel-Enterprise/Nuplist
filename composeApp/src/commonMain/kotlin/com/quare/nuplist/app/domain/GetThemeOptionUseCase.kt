package com.quare.nuplist.app.domain

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.quare.nuplist.core.option.PreferencesKeys
import com.quare.nuplist.core.option.SelectableOption
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetThemeOptionUseCase(
    private val dataStore: DataStore<Preferences>
) {
    suspend operator fun invoke(): SelectableOption.Theme = dataStore.data.map { value ->
        val theme = value[stringPreferencesKey(PreferencesKeys.THEME)]
        when (theme) {
            "light" -> SelectableOption.Theme.Light
            "dark" -> SelectableOption.Theme.Dark
            else -> SelectableOption.Theme.System
        }
    }.first()
}
