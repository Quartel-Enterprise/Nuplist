package com.quare.nuplist.ui.dialog.logout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.ktor.client.plugins.HttpRequestTimeoutException
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
            try {
                supabaseClient.auth.signOut()
            } catch (_: HttpRequestTimeoutException) {

            }
            _shouldShowLoadingInConfirm.update { false }
        }
    }
}
