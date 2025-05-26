package com.quare.nuplist.ui.appbar.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.quare.nuplist.ui.appbar.domain.AppBarActionIconModel
import com.quare.nuplist.ui.appbar.presentation.component.AppBarTitle
import com.quare.nuplist.ui.appbar.presentation.component.BackIcon
import com.quare.nuplist.ui.loading.LoadingComponent
import com.quare.nuplist.ui.utils.back.BackNavigationType
import com.quare.nuplist.ui.utils.back.LocalBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarComponent(
    appBarActionIconModel: AppBarActionIconModel?,
    modifier: Modifier = Modifier,
    title: String? = null,
    backType: BackNavigationType = BackNavigationType.NORMAL,
    contentBellowActionIcon: @Composable () -> Unit = {},
    contentBeforeActionIcon: @Composable () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TopAppBar(
        modifier = modifier,
        title = {
            title?.let {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AppBarTitle(
                        title = it,
                    )
                }
            }
        },
        navigationIcon = {
            if (backType == BackNavigationType.NONE) return@TopAppBar
            val lifecycleOwner = LocalLifecycleOwner.current
            val localBack = LocalBack.current
            BackIcon(
                onClick = {
                    if (lifecycleOwner.lifecycle.currentState == State.RESUMED) {
                        keyboardController?.hide()
                        localBack[backType]?.invoke()
                    }
                }
            )
        },
        actions = {
            AnimatedVisibility(appBarActionIconModel != null) {
                appBarActionIconModel?.run {
                    when (this) {
                        AppBarActionIconModel.Loading -> LoadingComponent(
                            modifier = Modifier.padding(end = 16.dp),
                            size = 24.dp,
                            strokeWidth = 2.dp
                        )

                        is AppBarActionIconModel.WithData -> Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            contentBeforeActionIcon()
                            IconButton(onClick = iconClick) {
                                Icon(
                                    imageVector = imageVector,
                                    contentDescription = iconDescription,
                                )
                            }
                            contentBellowActionIcon()
                        }
                    }
                }
            }
        }
    )
}
