package com.quare.nuplist.feature.login.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.flowers_512_512
import org.jetbrains.compose.resources.painterResource

@Composable
fun FlowersImage() {
    Image(
        painter = painterResource(Res.drawable.flowers_512_512),
        contentDescription = null
    )
}
