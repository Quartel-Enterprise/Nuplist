package com.quare.nuplist.feature.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.quare.nuplist.ui.spacer.VerticalSpacer
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.google_login_text
import nuplist.composeapp.generated.resources.google_logo
import nuplist.composeapp.generated.resources.login_headline
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreenContent(
    onLoginWithGoogleClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(Res.string.login_headline),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
            VerticalSpacer()
            LoginWithGoogleButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onLoginWithGoogleClick,
            )
        }
    }
}

@Composable
private fun LoginWithGoogleButton(modifier: Modifier, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterHorizontally,
            )
        ) {
            val text = stringResource(Res.string.google_login_text)
            Image(
                painter = painterResource(resource = Res.drawable.google_logo),
                contentDescription = text
            )
            Text(text)
        }
    }
}
