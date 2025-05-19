package com.quare.nuplist.ui.dialog.profile.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.close
import org.jetbrains.compose.resources.stringResource

@Composable
fun DialogProfileHeader(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable { onDismiss() },
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(Res.string.close),
        )

        Logo(
            modifier = Modifier.align(Alignment.Center),
            iconSize = 32.dp,
            fontSize = 19.sp,
            spaceAfterIcon = 4.dp
        )
    }
}
