package com.quare.nuplist.core.option

import androidx.compose.runtime.compositionLocalOf

val LocalOptionChange = compositionLocalOf<(SelectableOption) -> Unit> {
    error("No theme change callback provided")
}
