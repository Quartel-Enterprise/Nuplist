package com.quare.nuplist.ui.theme_selector.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiEvent
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiState
import com.quare.nuplist.ui.theme_selector.presentation.component.ThemeMenuAnimated
import com.quare.nuplist.ui.theme_selector.presentation.component.ThemeSelectorHeader

@Composable
fun ThemeSelectorContent(
    state: ThemeSelectorUiState,
    onEvent: (ThemeSelectorUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        ThemeSelectorHeader(
            isMenuExpanded = state.isMenuExpanded,
            modifier = Modifier.clickable {
                onEvent(ThemeSelectorUiEvent.ToggleMenu)
            },
        )

        ThemeMenuAnimated(
            state = state,
            onThemeSelected = {
                onEvent(ThemeSelectorUiEvent.SelectTheme(it))
            }
        )
    }
}
