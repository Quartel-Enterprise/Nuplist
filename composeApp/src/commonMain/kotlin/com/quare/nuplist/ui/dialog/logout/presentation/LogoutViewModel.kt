package com.quare.nuplist.ui.dialog.logout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogoutViewModel(
    private val supabaseClient: SupabaseClient,
): ViewModel() {

    private val _shouldShowLoadingInConfirm: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val shouldShowLoadingInConfirm = _shouldShowLoadingInConfirm.asStateFlow()

    fun logoutClicked() {
        _shouldShowLoadingInConfirm.update { true }
        viewModelScope.launch {
            supabaseClient.auth.signOut()
            _shouldShowLoadingInConfirm.update { false }
        }
    }
}
