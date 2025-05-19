package com.quare.nuplist.ui.theme_selector.presentation.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun ThemeMenuArrowIcon(isExpanded: Boolean) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "arrow icon rotation for theme selector"
    )
    Icon(
        imageVector = Icons.Default.KeyboardArrowDown,
        contentDescription = null,
        modifier = Modifier.rotate(rotationAngle)
    )
}
