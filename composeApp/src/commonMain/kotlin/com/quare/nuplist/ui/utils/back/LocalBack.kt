package com.quare.nuplist.ui.utils.back

import androidx.compose.runtime.compositionLocalOf

typealias BackNavigationMap = Map<BackNavigationType, () -> Unit>

val LocalBack = compositionLocalOf<BackNavigationMap> {
    error("No local back provided")
}
