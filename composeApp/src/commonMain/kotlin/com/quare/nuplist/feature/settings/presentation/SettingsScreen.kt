package com.quare.nuplist.feature.settings.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel = koinViewModel()) {
    val isLogoutLoading: Boolean by settingsViewModel.isLogoutLoading.collectAsState()
    if (isLogoutLoading) {
        CircularProgressIndicator()
    } else {
        Button(
            onClick = {
                settingsViewModel.onLogoutClick()
            }
        ) {
            Text(text = "Logout")
        }
    }
}
