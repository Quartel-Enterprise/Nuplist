package com.quare.nuplist.previews

import androidx.compose.runtime.Composable
import com.quare.nuplist.core.theme.AppTheme
import com.quare.nuplist.feature.login.presentation.screen.LoginScreenContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreenContentPreview() {
    AppTheme {
        LoginScreenContent(
            onEvent = {},
            onLoginWithGoogleClick = {},
        )
    }
}
