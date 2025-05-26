package com.quare.nuplist.ui.utils.back

import androidx.compose.runtime.compositionLocalOf

typealias BackNavigationMap = Map<BackNavigationType, () -> Unit>

val LocalBack = compositionLocalOf<BackNavigationMap> {
    error("No local back provided")
}

fun BackNavigationMap.popBackStack() {
    executeBackNavigation(BackNavigationType.NORMAL)
}

private fun BackNavigationMap.executeBackNavigation(backNavigationType: BackNavigationType) {
    get(backNavigationType)?.invoke() ?: error("No back navigation found for $backNavigationType")
}
