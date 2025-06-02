package com.quare.nuplist.ui.dialog.profile.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.quare.nuplist.core.option.LocalLanguageOption
import com.quare.nuplist.core.option.LocalOptionChange
import com.quare.nuplist.core.option.LocalThemeOption
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiAction
import org.koin.compose.viewmodel.koinViewModel

private const val CONTENT_FILL_PERCENTAGE = 0.9f

@Composable
fun ProfileDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    showPrivacyPolicyLinks: Boolean = false,
    userModel: UserModel? = null,
    onLogoutClick: (() -> Unit)? = null,
    viewModel: ProfileDialogViewModel = koinViewModel(),
) {
    val uriHandler = LocalUriHandler.current
    val localOptionChange = LocalOptionChange.current

    ActionCollector(
        flow = viewModel.uiAction,
        emit = { action ->
            when (action) {
                is ProfileDialogUiAction.OpenUri -> uriHandler.openUri(action.uri)
                is ProfileDialogUiAction.ChangeOption -> localOptionChange(action.option)
            }
        }
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        // TODO("Change to top: https://stackoverflow.com/questions/79648090/how-to-position-a-dialog-in-a-different-position-than-the-middle-in-compose-mult")
        ProfileDialogContent(
            modifier = modifier.fillMaxWidth(CONTENT_FILL_PERCENTAGE),
            userModel = userModel,
            onDismiss = onDismiss,
            onEvent = viewModel::dispatchUiEvent,
            currentTheme = LocalThemeOption.current,
            onLogoutClick = onLogoutClick,
            showPrivacyPolicyLinks = showPrivacyPolicyLinks,
            currentLanguage = LocalLanguageOption.current,
        )
    }
}
