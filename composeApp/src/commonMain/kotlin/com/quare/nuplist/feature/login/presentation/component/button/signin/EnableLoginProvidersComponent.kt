package com.quare.nuplist.feature.login.presentation.component.button.signin

import androidx.compose.runtime.Composable
import com.quare.nuplist.feature.login.domain.model.LoginProvider
import com.quare.nuplist.ui.spacer.VerticalSpacer

@Composable
fun EnableLoginProvidersComponent(
    providers: List<LoginProvider>,
    onLoginWithGoogleClick: () -> Unit,
    onLoginWithAppleClick: () -> Unit,
) {
    val size = providers.size
    providers.forEachIndexed { index, provider ->
        when (provider) {
            LoginProvider.GOOGLE -> GoogleSocialLoginButton(onLoginWithGoogleClick)
            LoginProvider.APPlE -> AppleSocialLoginButton(onLoginWithAppleClick)
        }
        if (index < size - 1) {
            VerticalSpacer()
        }
    }
}
