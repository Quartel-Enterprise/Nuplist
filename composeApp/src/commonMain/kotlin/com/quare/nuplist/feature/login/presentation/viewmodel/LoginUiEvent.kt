package com.quare.nuplist.feature.login.presentation.viewmodel

import io.github.jan.supabase.compose.auth.composable.NativeSignInState

interface LoginUiEvent {

    sealed interface SocialLoginClicked : LoginUiEvent {
        val nativeSignInState: NativeSignInState

        data class Google(override val nativeSignInState: NativeSignInState) : SocialLoginClicked
        data class Apple(override val nativeSignInState: NativeSignInState) : SocialLoginClicked
    }

    data object SettingsClick : LoginUiEvent
    data object OnDismissModal : LoginUiEvent
}
