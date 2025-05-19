package com.quare.nuplist.feature.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.quare.nuplist.core.utils.UiEventExecutor
import com.quare.nuplist.feature.login.domain.model.LoginUiState
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.composeAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    supabaseClient: SupabaseClient,
) : ViewModel(), UiEventExecutor<LoginUiEvent> {

    val composeAuth: ComposeAuth = supabaseClient.composeAuth
    private val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState(false))
    val state: StateFlow<LoginUiState> = _state

    override fun dispatchUiEvent(uiEvent: LoginUiEvent) {
        when (uiEvent) {
            LoginUiEvent.SettingsClick -> _state.update { it.copy(showSettingsDialog = true) }
            LoginUiEvent.OnDismissModal -> _state.update { it.copy(showSettingsDialog = false) }
            is LoginUiEvent.LoginWithGoogleClick -> uiEvent.nativeSignInState.startFlow()
        }
    }
}
