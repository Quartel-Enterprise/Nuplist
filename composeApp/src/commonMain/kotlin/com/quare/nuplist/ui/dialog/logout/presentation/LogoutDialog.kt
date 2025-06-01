package com.quare.nuplist.ui.dialog.logout.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.quare.nuplist.ui.dialog.common.DialogComponent
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.cancel
import nuplist.composeapp.generated.resources.confirm
import nuplist.composeapp.generated.resources.exit
import nuplist.composeapp.generated.resources.logout_dialog_message
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LogoutDialog(
    onDismiss: () -> Unit,
    viewModel: LogoutViewModel = koinViewModel(),
) {
    val shouldShowLoadingInConfirmButton by viewModel.shouldShowLoadingInConfirm.collectAsState()
    DialogComponent(
        icon = Icons.AutoMirrored.Filled.Logout,
        title = stringResource(Res.string.exit),
        middleContent = {
            Text(text = stringResource(Res.string.logout_dialog_message))
        },
        confirmButtonText = stringResource(Res.string.confirm),
        cancelButtonText = stringResource(Res.string.cancel),
        confirmButtonClick = viewModel::logoutClicked,
        shouldShowLoadingInConfirmButton = shouldShowLoadingInConfirmButton,
        onDismiss = onDismiss
    )
}
