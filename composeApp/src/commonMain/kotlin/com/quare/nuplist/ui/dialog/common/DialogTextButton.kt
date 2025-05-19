package com.quare.nuplist.ui.dialog.common

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DialogTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = text,
        )
    }
}
