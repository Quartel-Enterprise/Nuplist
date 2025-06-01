package com.quare.nuplist.ui.dialog.logout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.quare.nuplist.ui.dialog.common.DialogComponent
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.cancel
import nuplist.composeapp.generated.resources.confirm
import nuplist.composeapp.generated.resources.exit
import nuplist.composeapp.generated.resources.logout_dialog_message
import org.jetbrains.compose.resources.stringResource

@Composable
fun LogoutDialog(
    onLogout: () -> Unit,
    onDismiss: () -> Unit,
) {
    DialogComponent(
        icon = Icons.AutoMirrored.Filled.Logout,
        title = stringResource(Res.string.exit),
        middleContent = {
            Text(text = stringResource(Res.string.logout_dialog_message))
        },
        confirmButtonText = stringResource(Res.string.confirm),
        cancelButtonText = stringResource(Res.string.cancel),
        confirmButtonClick = onLogout,
        onDismiss = onDismiss,
    )
}
