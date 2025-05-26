package com.quare.nuplist.ui.dialog.profile.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    iconSize: Dp = 60.dp,
    fontSize: TextUnit = 48.sp,
    spaceAfterIcon: Dp = 8.dp,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.app_name),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                letterSpacing = 0.sp,
            ),
        )
    }
}
