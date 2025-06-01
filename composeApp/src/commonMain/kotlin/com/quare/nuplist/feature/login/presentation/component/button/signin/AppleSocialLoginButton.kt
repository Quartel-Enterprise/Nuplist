package com.quare.nuplist.feature.login.presentation.component.button.signin

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.ui.theme.isAppInDarkTheme
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.apple_icon_dark
import nuplist.composeapp.generated.resources.apple_icon_white
import nuplist.composeapp.generated.resources.apple_login_text

@Composable
fun AppleSocialLoginButton(onClick: () -> Unit) {
    SocialLoginButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        textResource = Res.string.apple_login_text,
        drawableResource = if (isAppInDarkTheme()) {
            Res.drawable.apple_icon_white
        } else {
            Res.drawable.apple_icon_dark
        },
    )
}
