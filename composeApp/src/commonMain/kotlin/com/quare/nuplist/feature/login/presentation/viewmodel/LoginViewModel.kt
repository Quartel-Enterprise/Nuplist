package com.quare.nuplist.feature.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.utils.UiEventExecutor
import com.quare.nuplist.feature.login.domain.model.LoginProvider
import com.quare.nuplist.feature.login.domain.model.LoginUiState
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.composeAuth
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    supabaseClient: SupabaseClient,
) : ViewModel(), UiEventExecutor<LoginUiEvent> {

    val composeAuth: ComposeAuth = supabaseClient.composeAuth
    private val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(
        LoginUiState(
            enabledProviders = listOf(LoginProvider.GOOGLE)
        )
    )
    val state: StateFlow<LoginUiState> = _state

    private val _settingsUiAction: Channel<Unit> = Channel()
    val settingsUiAction = _settingsUiAction.receiveAsFlow()

    override fun dispatchUiEvent(uiEvent: LoginUiEvent) {
        when (uiEvent) {
            is LoginUiEvent.SocialLoginClicked -> uiEvent.nativeSignInState.startFlow()
            is LoginUiEvent.SettingsClick -> viewModelScope.launch {
                _settingsUiAction.send(Unit)
            }
        }
    }
}
