package com.quare.nuplist.core.navigation.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.core.navigation.domain.RootNavigation
import com.quare.nuplist.feature.login.data.mapper.SessionUserMapper
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.status.SessionStatus
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RootNavigationViewModel(
    private val userMapper: SessionUserMapper,
    supabaseClient: SupabaseClient,
) : ViewModel() {

    private val _navigateChannel: Channel<RootNavigation> = Channel()
    val navigateChannel = _navigateChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            supabaseClient.auth.sessionStatus.collect { sessionStatus ->
                _navigateChannel.send(
                    when (sessionStatus) {
                        is SessionStatus.Authenticated -> sessionStatus.session.user
                            ?.let(userMapper::map)
                            ?.let(RootNavigation::Main) ?: return@collect

                        SessionStatus.Initializing -> return@collect
                        is SessionStatus.NotAuthenticated -> RootNavigation.Login
                        is SessionStatus.RefreshFailure -> RootNavigation.Login
                    }
                )
            }
        }
    }
}
