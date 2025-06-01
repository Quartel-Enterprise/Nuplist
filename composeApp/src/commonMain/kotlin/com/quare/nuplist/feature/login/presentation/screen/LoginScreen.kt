package com.quare.nuplist.feature.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginUiEvent
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginViewModel
import com.quare.nuplist.ui.dialog.profile.presentation.ProfileDialog
import io.github.jan.supabase.compose.auth.composable.GoogleDialogType
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
) {
    val composeAuth = viewModel.composeAuth
    val googleAuthState = composeAuth.rememberSignInWithGoogle(
        type = GoogleDialogType.BOTTOM_SHEET,
    )
//    val appleAuthState = composeAuth.rememberSignInWithApple(onResult = {})
    val onEvent: (LoginUiEvent) -> Unit = viewModel::dispatchUiEvent
    val state by viewModel.state.collectAsState()
    if (state.showSettingsDialog) {
        ProfileDialog(
            onDismiss = {
                onEvent(LoginUiEvent.OnDismissModal)
            }
        )
    }
    LoginScreenContent(
        onLoginWithGoogleClick = {
            onEvent(LoginUiEvent.SocialLoginClicked.Google(googleAuthState))
        },
        onLoginWithAppleClick = {
//            onEvent(LoginUiEvent.SocialLoginClicked.Apple(googleAuthState))
        },
        onEvent = onEvent,
        enableProviders = state.enabledProviders,
    )
}
