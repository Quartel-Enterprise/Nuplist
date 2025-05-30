package com.quare.nuplist.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.onNullableClick(onClick: (() -> Unit)?): Modifier = onClick?.let {
    this.clickable(onClick = onClick)
} ?: this
