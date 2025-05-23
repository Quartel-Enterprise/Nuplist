package com.quare.nuplist.ui.dialog.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.core.theme.ThemeOption
import com.quare.nuplist.ui.dialog.profile.component.DialogProfileHeader
import com.quare.nuplist.ui.dialog.profile.component.LogoutOption
import com.quare.nuplist.ui.dialog.profile.component.UserPictureNameAndEmail
import com.quare.nuplist.ui.dialog.profile.component.link.LinksRow
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogState
import com.quare.nuplist.ui.dialog.profile.model.ProfileDialogUiEvent
import com.quare.nuplist.ui.spacer.VerticalSpacer
import com.quare.nuplist.ui.theme_selector.presentation.ThemeSelector

@Composable
fun ProfileDialogContent(
    currentTheme: ThemeOption,
    state: ProfileDialogState?,
    onDismiss: () -> Unit,
    onLogout: (() -> Unit)?,
    onEvent: (ProfileDialogUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(
                    top = 24.dp,
                    bottom = 4.dp
                ),
            horizontalAlignment = Alignment.Start
        ) {
            DialogProfileHeader(onDismiss)
            VerticalSpacer(24)
            state?.let {
                UserPictureNameAndEmail(
                    modifier = Modifier.fillMaxWidth(),
                    user = state
                )
            }
            VerticalSpacer(24)
            ThemeSelector(
                currentTheme = currentTheme,
                onThemeChange = {
                    onEvent(ProfileDialogUiEvent.SelectTheme(it))
                }
            )
            VerticalSpacer(24)
            onLogout?.let {
                LogoutOption(onLogout = it)
            }
            VerticalSpacer(4)
            Box(modifier = Modifier.fillMaxWidth()) {
                LinksRow(
                    modifier = Modifier.align(Alignment.Center),
                    goToLink = {
                        onEvent(ProfileDialogUiEvent.LinkClick(it))
                    }
                )
            }
        }
    }
}
