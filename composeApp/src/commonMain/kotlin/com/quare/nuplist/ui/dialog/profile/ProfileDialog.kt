package com.quare.nuplist.ui.dialog.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.quare.nuplist.core.theme.LocalThemeChanged
import com.quare.nuplist.core.theme.LocalThemeOption
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogUiAction
import org.koin.compose.viewmodel.koinViewModel

private const val CONTENT_FILL_PERCENTAGE = 0.9f

@Composable
fun ProfileDialog(
    onDismiss: () -> Unit,
    onLogout: (() -> Unit)? = null,
    viewModel: ProfileDialogViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val uriHandler = LocalUriHandler.current
    val localThemeChanged = LocalThemeChanged.current

    ActionCollector(
        flow = viewModel.uiAction,
        emit = { action ->
            when (action) {
                is ProfileDialogUiAction.OpenUri -> uriHandler.openUri(action.uri)
                is ProfileDialogUiAction.ChangeTheme -> localThemeChanged(action.theme)
            }
        }
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        ProfileDialogContent(
            modifier = Modifier.fillMaxWidth(CONTENT_FILL_PERCENTAGE),
            state = state,
            onDismiss = onDismiss,
            onLogout = onLogout,
            onEvent = viewModel::dispatchUiEvent,
            currentTheme = LocalThemeOption.current
        )
    }
}
