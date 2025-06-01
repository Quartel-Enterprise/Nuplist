package com.quare.nuplist.feature.login.presentation.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginHeadlineText(
    modifier: Modifier = Modifier,
    stringResource: StringResource,
) {
    Text(
        modifier = modifier,
        text = stringResource(stringResource),
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold
    )
}
