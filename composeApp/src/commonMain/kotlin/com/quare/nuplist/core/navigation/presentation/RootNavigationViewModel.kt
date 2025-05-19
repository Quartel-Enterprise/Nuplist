package com.quare.nuplist.core.navigation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.navigation.domain.RootNavigation
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.status.SessionStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RootNavigationViewModel(
    supabaseClient: SupabaseClient,
) : ViewModel() {
    private val _firstScreen: MutableStateFlow<RootNavigation> = MutableStateFlow(RootNavigation.Loading)
    val firstScreen: StateFlow<RootNavigation> = _firstScreen

    init {
        viewModelScope.launch {
            supabaseClient.auth.sessionStatus.collect { sessionStatus ->
                _firstScreen.update {
                    when(sessionStatus) {
                        is SessionStatus.Authenticated -> RootNavigation.Main
                        SessionStatus.Initializing -> RootNavigation.Loading
                        is SessionStatus.NotAuthenticated -> RootNavigation.Login
                        is SessionStatus.RefreshFailure -> RootNavigation.Login
                    }
                }
            }
        }
    }
}
