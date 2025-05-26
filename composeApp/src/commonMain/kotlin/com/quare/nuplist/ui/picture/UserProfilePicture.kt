package com.quare.nuplist.ui.picture

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.quare.nuplist.ui.utils.onNullableClick
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.profile_icon
import nuplist.composeapp.generated.resources.profile_picture
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserProfilePicture(
    photoUrl: String?,
    size: Dp,
    modifier: Modifier = Modifier,
    isHighlighted: Boolean = false,
    contentDescription: String? = null,
    onPhotoClick: (() -> Unit)? = null,
) {
    val profileResource = painterResource(resource = Res.drawable.profile_icon)
    val shape = CircleShape
    Surface(
        modifier = modifier
            .clip(shape)
            .onNullableClick(onPhotoClick),
        border = BorderStroke(
            width = 3.dp,
            color = MaterialTheme.colorScheme.primary
        ).takeIf { isHighlighted },
        shape = shape,
    ) {
        val photoUrlModifier = modifier
            .clip(shape)
            .size(size)
        Picture(
            modifier = photoUrlModifier,
            url = photoUrl,
            contentDescription = contentDescription
                ?: stringResource(Res.string.profile_picture),
            onPhotoClick = onPhotoClick,
            error = profileResource,
            placeholder = profileResource
        )
    }
}
