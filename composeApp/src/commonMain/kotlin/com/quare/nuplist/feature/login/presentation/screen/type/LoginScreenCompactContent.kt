package com.quare.nuplist.feature.login.presentation.screen.type

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.quare.nuplist.feature.login.presentation.component.FlowersImage
import com.quare.nuplist.feature.login.presentation.component.button.signin.AppleSocialLoginButton
import com.quare.nuplist.feature.login.presentation.component.button.signin.GoogleSocialLoginButton
import com.quare.nuplist.feature.login.presentation.component.text.LoginHeadlineText
import com.quare.nuplist.ui.spacer.VerticalSpacer
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.login_headline

@Composable
fun BoxWithConstraintsScope.LoginScreenCompactContent(
    modifier: Modifier = Modifier,
    onLoginWithGoogleClick: () -> Unit,
    onLoginWithAppleClick: () -> Unit,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .align(Alignment.Center)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginHeadlineText(
            stringResource = Res.string.login_headline,
        )
        VerticalSpacer(48)
        FlowersImage()
        VerticalSpacer(48)
        GoogleSocialLoginButton(onLoginWithGoogleClick)
        VerticalSpacer(16)
        AppleSocialLoginButton(onLoginWithAppleClick)
    }
}
