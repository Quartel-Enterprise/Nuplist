package com.quare.nuplist.feature.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginUiEvent
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginViewModel
import io.github.jan.supabase.compose.auth.composable.GoogleDialogType
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithApple
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    goToSettings: () -> Unit,
) {
    val composeAuth = viewModel.composeAuth
    val googleAuthState = composeAuth.rememberSignInWithGoogle(
        type = GoogleDialogType.BOTTOM_SHEET,
    )
    val appleAuthState = composeAuth.rememberSignInWithApple(onResult = {})
    val onEvent: (LoginUiEvent) -> Unit = viewModel::dispatchUiEvent
    val state by viewModel.state.collectAsState()
    ActionCollector(viewModel.settingsUiAction) {
        goToSettings()
    }
    LoginScreenContent(
        onLoginWithGoogleClick = {
            onEvent(LoginUiEvent.SocialLoginClicked.Google(googleAuthState))
        },
        onLoginWithAppleClick = {
            onEvent(LoginUiEvent.SocialLoginClicked.Apple(appleAuthState))
        },
        onEvent = onEvent,
        enableProviders = state.enabledProviders,
    )
}
