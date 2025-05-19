package com.quare.nuplist.feature.login.presentation.viewmodel

import io.github.jan.supabase.compose.auth.composable.NativeSignInState

interface LoginUiEvent {
    data class LoginWithGoogleClick(val nativeSignInState: NativeSignInState) : LoginUiEvent
    data object SettingsClick : LoginUiEvent
    data object OnDismissModal : LoginUiEvent
}
