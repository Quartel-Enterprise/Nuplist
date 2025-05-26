package com.quare.nuplist.ui.dialog.profile.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.nuplist.ui.spacer.HorizontalSpacer
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.exit
import org.jetbrains.compose.resources.stringResource

@Composable
fun LogoutOption(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.error,
    onLogout: () -> Unit
) {
    Row(
        modifier = modifier.clickable { onLogout() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        val exitText = stringResource(Res.string.exit)
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = Icons.AutoMirrored.Filled.Logout,
            tint = color,
            contentDescription = exitText
        )
        HorizontalSpacer(10)
        Text(
            text = exitText,
            color = color,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
