package com.quare.nuplist.ui.dialog.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DialogComponent(
    title: String,
    confirmButtonText: String,
    confirmButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    middleContent: @Composable (() -> Unit),
    icon: ImageVector? = null,
    iconDescription: String? = null,
    cancelButtonText: String? = null,
    cancelButtonClick: (() -> Unit)? = null,
) {
    AlertDialog(
        icon = {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = iconDescription,
                )
            }
        },
        title = {
            Text(text = title)
        },
        text = middleContent,
        confirmButton = {
            DialogTextButton(
                text = confirmButtonText,
                onClick = confirmButtonClick
            )
        },
        dismissButton = {
            cancelButtonText?.let {
                DialogTextButton(
                    text = it,
                    onClick = {
                        cancelButtonClick?.invoke() ?: onDismiss()
                    }
                )
            }
        },
        onDismissRequest = onDismiss
    )
}
