package com.quare.nuplist.ui.dialog.profile.presentation

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
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.ui.dialog.profile.presentation.component.DialogProfileHeader
import com.quare.nuplist.ui.dialog.profile.presentation.component.LogoutOption
import com.quare.nuplist.ui.dialog.profile.presentation.component.UserPictureNameAndEmail
import com.quare.nuplist.ui.dialog.profile.presentation.component.link.LinksRow
import com.quare.nuplist.ui.dialog.profile.presentation.model.ProfileDialogUiEvent
import com.quare.nuplist.ui.spacer.VerticalSpacer
import com.quare.nuplist.ui.theme_selector.presentation.Selector

@Composable
fun ProfileDialogContent(
    modifier: Modifier = Modifier,
    currentTheme: SelectableOption.Theme,
    currentLanguage: SelectableOption.Language,
    showPrivacyPolicyLinks: Boolean,
    userModel: UserModel?,
    onDismiss: () -> Unit,
    onEvent: (ProfileDialogUiEvent) -> Unit,
    onLogoutClick: (() -> Unit)?,
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
            userModel?.let {
                UserPictureNameAndEmail(
                    modifier = Modifier.fillMaxWidth(),
                    user = userModel
                )
            }
            VerticalSpacer(24)
            CardSelectors(
                modifier = Modifier.fillMaxWidth(),
                currentTheme = currentTheme,
                onEvent = onEvent,
                currentLanguage = currentLanguage
            )
            VerticalSpacer(24)
            onLogoutClick?.let {
                LogoutOption(onLogout = it)
            }
            if (showPrivacyPolicyLinks) {
                VerticalSpacer(4)
                Box(modifier = Modifier.fillMaxWidth()) {
                    LinksRow(
                        modifier = Modifier.align(Alignment.Center),
                        goToLink = {
                            onEvent(ProfileDialogUiEvent.LinkClick(it))
                        }
                    )
                }
            } else {
                VerticalSpacer(24)
            }
        }
    }
}

@Composable
private fun CardSelectors(
    modifier: Modifier = Modifier,
    currentTheme: SelectableOption.Theme,
    onEvent: (ProfileDialogUiEvent) -> Unit,
    currentLanguage: SelectableOption.Language,
) {
    Card(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Selector(
                options = listOf(
                    SelectableOption.Theme.Light,
                    SelectableOption.Theme.Dark,
                    SelectableOption.Theme.System,
                ),
                currentOption = currentTheme,
                onOptionChange = {
                    onEvent(ProfileDialogUiEvent.SelectOption(it))
                }
            )
            Selector(
                options = listOf(
                    SelectableOption.Language.English,
                    SelectableOption.Language.PortugueseBrazil,
                ),
                currentOption = currentLanguage,
                onOptionChange = {
                    onEvent(ProfileDialogUiEvent.SelectOption(it))
                }
            )
        }
    }
}
