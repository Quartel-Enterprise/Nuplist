package com.quare.nuplist.ui.dialog.language_changed

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.ui.dialog.common.DialogComponent
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.confirm
import nuplist.composeapp.generated.resources.language_change_message
import nuplist.composeapp.generated.resources.language_change_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun RestartAppDialog(
    modifier: Modifier,
    onDismiss: () -> Unit,
) {
    DialogComponent(
        modifier = modifier,
        title = stringResource(Res.string.language_change_title),
        middleContent = {
            Text(text = stringResource(Res.string.language_change_message))
        },
        confirmButtonText = stringResource(Res.string.confirm),
        confirmButtonClick = onDismiss,
        onDismiss = onDismiss,
    )
}
