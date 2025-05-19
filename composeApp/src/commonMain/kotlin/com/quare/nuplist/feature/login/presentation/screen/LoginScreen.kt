package com.quare.nuplist.feature.login.presentation.screen

import androidx.compose.runtime.Composable
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginViewModel
import io.github.jan.supabase.compose.auth.composable.GoogleDialogType
import io.github.jan.supabase.compose.auth.composable.NativeSignInState
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
) {
    val authState: NativeSignInState = viewModel.composeAuth.rememberSignInWithGoogle(
        type = GoogleDialogType.BOTTOM_SHEET,
    )
    LoginScreenContent(
        onLoginWithGoogleClick = authState::startFlow,
    )
}
