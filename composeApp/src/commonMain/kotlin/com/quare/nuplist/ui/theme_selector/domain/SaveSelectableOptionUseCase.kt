package com.quare.nuplist.ui.theme_selector.domain

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.quare.nuplist.core.option.SelectableOption

class SaveSelectableOptionUseCase(
    private val dataStore: DataStore<Preferences>,
) {

    suspend operator fun invoke(option: SelectableOption) {
        if (option is SelectableOption.Theme) {
            dataStore.edit {
                it[stringPreferencesKey(option.key)] = when (option) {
                    SelectableOption.Theme.Dark -> "dark"
                    SelectableOption.Theme.Light -> "light"
                    SelectableOption.Theme.System -> "system"
                }
            }
        }
    }
}
