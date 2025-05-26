package com.quare.nuplist.ui.dialog.profile.presentation.component.link

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LinkTextButton(
    textId: StringResource,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = stringResource(textId),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
