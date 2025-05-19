package com.quare.nuplist.ui.dialog.profile.component.link

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.ui.dialog.profile.model.WebLink
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.privacy_policy
import nuplist.composeapp.generated.resources.terms_of_service

@Composable
fun LinksRow(
    modifier: Modifier = Modifier,
    goToLink: (WebLink) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LinkTextButton(
            textId = Res.string.privacy_policy,
            onClick = {
                goToLink(WebLink.PRIVACY_POLICY)
            }
        )
        Icon(
            modifier = Modifier.size(3.dp),
            imageVector = Icons.Filled.Circle,
            contentDescription = null
        )
        LinkTextButton(
            textId = Res.string.terms_of_service,
            onClick = {
                goToLink(WebLink.TERMS_OF_SERVICE)
            }
        )
    }
}
