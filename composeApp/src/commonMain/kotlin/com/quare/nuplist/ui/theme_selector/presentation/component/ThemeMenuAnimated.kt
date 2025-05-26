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
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.ui.theme_selector.domain.SelectorUiState

private const val ANIMATION_DURATION_MILLIS = 300

@Composable
fun MenuAnimated(
    state: SelectorUiState,
    options: List<SelectableOption>,
    onOptionSelected: (SelectableOption) -> Unit
) {
    AnimatedVisibility(
        visible = state.isMenuExpanded,
        enter = expandVertically(animationSpec = tween(ANIMATION_DURATION_MILLIS)) + fadeIn(),
        exit = shrinkVertically(animationSpec = tween(ANIMATION_DURATION_MILLIS)) + fadeOut()
    ) {
        OptionMenu(
            modifier = Modifier
                .fillMaxWidth(),
            currentOption = state.optionSelected,
            onOptionSelected = onOptionSelected,
            startSpacing = 16,
            options = options,
        )
    }
}
