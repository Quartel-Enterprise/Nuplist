package com.quare.nuplist.ui.picture

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImagePainter

@Composable
fun Picture(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onPhotoClick: (() -> Unit)? = null,
    error: Painter? = null,
    placeholder: Painter? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
    contentDescription: String?,
) {
    PictureCommon(
        model = url,
        modifier = modifier,
        contentScale = contentScale,
        onPhotoClick = onPhotoClick,
        error = error,
        placeholder = placeholder,
        onError = onError,
        contentDescription = contentDescription
    )
}
