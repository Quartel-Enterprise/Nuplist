package com.quare.nuplist.feature.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.composeAuth

class LoginViewModel(
    supabaseClient: SupabaseClient,
) : ViewModel() {
    val composeAuth: ComposeAuth = supabaseClient.composeAuth
}
