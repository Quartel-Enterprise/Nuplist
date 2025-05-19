package com.quare.nuplist.ui.theme_selector.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.quare.nuplist.core.theme.ThemeOption

@Composable
fun themeSelectorViewModel(
    themeSelected: ThemeOption,
    onThemeChange: (ThemeOption) -> Unit,
): ThemeSelectorViewModel = viewModel(
    factory = viewModelFactory {
        initializer {
            ThemeSelectorViewModel(
                themeSelected = themeSelected,
                onThemeChange = onThemeChange
            )
        }
    }
)
