package com.quare.nuplist.feature.login.presentation.component.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingsIconButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = stringResource(Res.string.settings)
        )
    }
}
