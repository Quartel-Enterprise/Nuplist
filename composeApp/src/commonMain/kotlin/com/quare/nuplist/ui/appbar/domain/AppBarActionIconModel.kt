package com.quare.nuplist.ui.appbar.domain

import androidx.compose.ui.graphics.vector.ImageVector

sealed interface AppBarActionIconModel {
    data class WithData(
        val imageVector: ImageVector,
        val iconDescription: String,
        val iconClick: () -> Unit,
    ): AppBarActionIconModel

    data object Loading : AppBarActionIconModel
}
