package com.quare.nuplist.feature.login.presentation.screen.type

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.feature.login.presentation.component.FlowersImage
import com.quare.nuplist.feature.login.presentation.component.button.signin.AppleSocialLoginButton
import com.quare.nuplist.feature.login.presentation.component.button.signin.GoogleSocialLoginButton
import com.quare.nuplist.feature.login.presentation.component.text.LoginHeadlineText
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import com.quare.nuplist.ui.spacer.VerticalSpacer
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.login_headline_first_line
import nuplist.composeapp.generated.resources.login_headline_second_line

@Composable
fun BoxWithConstraintsScope.LoginScreenLargeContent(
    onLoginWithGoogleClick: () -> Unit,
    onLoginWithAppleClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .widthIn(max = 700.dp)
            .align(Alignment.Center)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        RightContent()
        HorizontalSpacer()
        VerticalDivider(
        )
        HorizontalSpacer()
        LeftContent(onLoginWithGoogleClick, onLoginWithAppleClick)
    }
}

@Composable
private fun RightContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginHeadlineText(
            stringResource = Res.string.login_headline_first_line,
        )
        LoginHeadlineText(
            stringResource = Res.string.login_headline_second_line,
        )
        VerticalSpacer(24)
        FlowersImage()
    }
}

@Composable
private fun LeftContent(
    onLoginWithGoogleClick: () -> Unit,
    onLoginWithAppleClick: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.Center) {
        GoogleSocialLoginButton(onLoginWithGoogleClick)
        VerticalSpacer(16)
        AppleSocialLoginButton(onLoginWithAppleClick)
    }
}
