package com.quare.nuplist.feature.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val supabaseClient: SupabaseClient,
) : ViewModel() {

    private val _isLogoutLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLogoutLoading: StateFlow<Boolean> = _isLogoutLoading

    fun onLogoutClick() {
        _isLogoutLoading.update { true }
        viewModelScope.launch {
            supabaseClient.auth.signOut()
            _isLogoutLoading.update { false }
        }
    }
}
