package com.quare.nuplist.feature.login.presentation.component.button.signin

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.ui.theme.isAppInDarkTheme
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.google_icon_dark
import nuplist.composeapp.generated.resources.google_icon_white
import nuplist.composeapp.generated.resources.google_login_text

@Composable
fun GoogleSocialLoginButton(onClick: () -> Unit) {
    SocialLoginButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        textResource = Res.string.google_login_text,
        drawableResource = if (isAppInDarkTheme()) {
            Res.drawable.google_icon_white
        } else {
            Res.drawable.google_icon_dark
        },
    )
}
