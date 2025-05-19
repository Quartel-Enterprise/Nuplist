package com.quare.nuplist.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.app.domain.GetThemeOptionUseCase
import com.quare.nuplist.core.theme.ThemeOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val getThemeOption: GetThemeOptionUseCase,
): ViewModel() {

    private val _themeOption: MutableStateFlow<ThemeOption?> = MutableStateFlow(null)
    val themeOption: StateFlow<ThemeOption?> = _themeOption

    init {
        updateThemeOption()
    }

    private fun updateThemeOption() {
        viewModelScope.launch {
            _themeOption.update {
                getThemeOption()
            }
        }
    }

    fun onThemeChange(theme: ThemeOption) {
        _themeOption.update { theme }
    }
}
