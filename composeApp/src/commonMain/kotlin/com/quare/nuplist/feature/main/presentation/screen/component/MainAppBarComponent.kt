package com.quare.nuplist.feature.main.presentation.screen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.nuplist.feature.main.domain.MainScreenUiEvent
import com.quare.nuplist.ui.picture.UserProfilePicture

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBarComponent(
    userPhoto: String?,
    onEvent: (MainScreenUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        actions = {
            UserProfilePicture(
                size = 30.dp,
                modifier = Modifier.padding(end = 8.dp),
                photoUrl = userPhoto,
                onPhotoClick = { onEvent(MainScreenUiEvent.ProfilePictureClicked) },
            )
        }
    )
}

