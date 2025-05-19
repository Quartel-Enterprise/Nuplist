package com.quare.nuplist.ui.theme_selector.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiEvent
import com.quare.nuplist.ui.theme_selector.presentation.viewmodel.ThemeSelectorViewModel
import com.quare.nuplist.ui.theme_selector.presentation.viewmodel.themeSelectorViewModel

@Composable
fun ThemeSelector(
    currentTheme: ThemeOption,
    onThemeChange: (ThemeOption) -> Unit,
    modifier: Modifier = Modifier,
    viewmodel: ThemeSelectorViewModel = themeSelectorViewModel(
        themeSelected = currentTheme,
        onThemeChange = onThemeChange,
    ),
) {
    val onEvent = viewmodel::dispatchUiEvent
    val state by viewmodel.state.collectAsState()

    LaunchedEffect(currentTheme) {
        onEvent(ThemeSelectorUiEvent.SelectTheme(currentTheme))
    }

    ThemeSelectorContent(
        modifier = modifier,
        onEvent = onEvent,
        state = state
    )

    DisposableEffect(Unit) {
        onDispose {
            onEvent(ThemeSelectorUiEvent.CloseMenu)
        }
    }
}
