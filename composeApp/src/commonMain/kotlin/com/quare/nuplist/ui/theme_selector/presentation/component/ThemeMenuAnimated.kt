package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.ui.theme_selector.domain.ThemeSelectorUiState

private const val ANIMATION_DURATION_MILLIS = 300

@Composable
fun ThemeMenuAnimated(
    state: ThemeSelectorUiState,
    onThemeSelected: (ThemeOption) -> Unit
) {
    AnimatedVisibility(
        visible = state.isMenuExpanded,
        enter = expandVertically(animationSpec = tween(ANIMATION_DURATION_MILLIS)) + fadeIn(),
        exit = shrinkVertically(animationSpec = tween(ANIMATION_DURATION_MILLIS)) + fadeOut()
    ) {
        ThemeMenu(
            modifier = Modifier
                .fillMaxWidth(),
            currentTheme = state.themeSelected,
            onThemeSelected = onThemeSelected,
            startSpacing = 16
        )
    }
}
