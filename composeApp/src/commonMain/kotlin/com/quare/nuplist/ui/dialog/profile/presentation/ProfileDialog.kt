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
import com.quare.nuplist.ui.dialog.profile.presentation.model.LogoutModel
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiAction
import org.koin.compose.viewmodel.koinViewModel

private const val CONTENT_FILL_PERCENTAGE = 0.9f

@Composable
fun ProfileDialog(
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit,
    onDismiss: () -> Unit,
    showPrivacyPolicyLinks: Boolean = false,
    shouldShowLogout: Boolean,
    userModel: UserModel? = null,
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
        ProfileDialogContent(
            modifier = modifier.fillMaxWidth(CONTENT_FILL_PERCENTAGE),
            userModel = userModel,
            onDismiss = onDismiss,
            onEvent = viewModel::dispatchUiEvent,
            currentTheme = LocalThemeOption.current,
            logoutModel = LogoutModel(
                onClick = onLogoutClick,
                isLoading = false,
            ).takeIf { shouldShowLogout },
            showPrivacyPolicyLinks = showPrivacyPolicyLinks,
            currentLanguage = LocalLanguageOption.current,
        )
    }
}
