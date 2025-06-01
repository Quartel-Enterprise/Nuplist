package com.quare.nuplist.ui.picture

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.quare.nuplist.ui.theme.isAppInDarkTheme
import com.quare.nuplist.ui.utils.onNullableClick
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.img_fallback_dark
import nuplist.composeapp.generated.resources.img_fallback_light
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun PictureCommon(
    model: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onPhotoClick: (() -> Unit)? = null,
    error: Painter? = null,
    placeholder: Painter? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
    contentDescription: String?,
) {

    var isLoading by remember { mutableStateOf(true) }

    AsyncImage(
        modifier = modifier
            .onNullableClick(onPhotoClick),
        model = model,
        contentDescription = contentDescription,
        contentScale = contentScale,
        error = error ?: painterResource(
            if (isAppInDarkTheme()) {
                Res.drawable.img_fallback_dark
            } else {
                Res.drawable.img_fallback_light
            }
        ),
        placeholder = placeholder,
        onLoading = {
            isLoading = true
        },
        onError = { state ->
            isLoading = false
            onError?.invoke(state)
        }
    )
}
