package com.quare.nuplist.feature.login.presentation.screen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.feature.login.presentation.component.button.SettingsIconButton
import com.quare.nuplist.feature.login.presentation.screen.type.LoginScreenCompactContent
import com.quare.nuplist.feature.login.presentation.screen.type.LoginScreenLargeContent
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginUiEvent

private const val LOGIN_SCREEN_WIDTH_BREAKPOINT = 700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenContent(
    onEvent: (LoginUiEvent) -> Unit,
    onLoginWithGoogleClick: () -> Unit,
    onLoginWithAppleClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                actions = {
                    SettingsIconButton(
                        onClick = { onEvent(LoginUiEvent.SettingsClick) },
                    )
                },
                title = {}
            )
        }
    ) { paddingValues: PaddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
        ) {
            if (maxWidth < LOGIN_SCREEN_WIDTH_BREAKPOINT.dp) {
                LoginScreenCompactContent(
                    onLoginWithGoogleClick = onLoginWithGoogleClick,
                    onLoginWithAppleClick = onLoginWithAppleClick,
                )
            } else {
                LoginScreenLargeContent(
                    onLoginWithGoogleClick = onLoginWithGoogleClick,
                    onLoginWithAppleClick = onLoginWithAppleClick
                )
            }
        }
    }
}
