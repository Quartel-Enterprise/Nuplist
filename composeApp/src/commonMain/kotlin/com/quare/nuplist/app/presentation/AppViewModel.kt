package com.quare.nuplist.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.app.domain.GetLanguageOptionUseCase
import com.quare.nuplist.app.domain.GetThemeOptionUseCase
import com.quare.nuplist.core.internationalization.domain.Localization
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.core.option.SelectedOptions
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val getThemeOption: GetThemeOptionUseCase,
    private val getLanguageOption: GetLanguageOptionUseCase,
    private val localization: Localization,
) : ViewModel() {

    private val _selectableOptions: MutableStateFlow<SelectedOptions?> =
        MutableStateFlow(null)
    val selectableOptions: StateFlow<SelectedOptions?> = _selectableOptions

    private val _restartTheAppAction: MutableSharedFlow<Unit> = MutableSharedFlow()
    val restartTheAppAction: MutableSharedFlow<Unit> = _restartTheAppAction

    init {
        updateUserPreferences()
    }

    private fun updateUserPreferences() {
        viewModelScope.launch {
            val themeOptionDeferred = async { getThemeOption() }
            val languageOptionDeferred = async { getLanguageOption() }
            val language = languageOptionDeferred.await()
            localization.applyLanguage(language)
            _selectableOptions.update {
                SelectedOptions(
                    theme = themeOptionDeferred.await(),
                    language = language,
                )
            }
        }
    }

    fun onOptionChange(option: SelectableOption) {
        _selectableOptions.update {
            it?.copy(
                theme = if (option is SelectableOption.Theme) option else it.theme,
                language = if (option is SelectableOption.Language) {
                    if (option != it.language) {
                        localization.applyLanguage(option)
                        viewModelScope.launch {
                            _restartTheAppAction.emit(Unit)
                        }
                    }
                    option
                } else it.language,
            )
        }
    }
}
