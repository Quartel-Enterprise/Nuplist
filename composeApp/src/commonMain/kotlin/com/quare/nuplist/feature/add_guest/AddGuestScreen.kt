package com.quare.nuplist.feature.add_guest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isBackPressed
import androidx.compose.ui.input.pointer.pointerInput
import com.quare.nuplist.ui.appbar.domain.AppBarActionIconModel
import com.quare.nuplist.ui.appbar.presentation.AppBarComponent
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.add_guest
import org.jetbrains.compose.resources.stringResource

@Composable
fun AddGuestScreen(
    back: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = stringResource(Res.string.add_guest)
    val checkIcon = Icons.Default.Check
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    val event = awaitPointerEvent()
                    if (event.type == PointerEventType.Press &&
                        event.buttons.isBackPressed
                    ) {
                        event.changes.forEach { e ->
                            e.consume()
                        }
                        back()
                    }
                }
            },
        topBar = {
            AppBarComponent(
                appBarActionIconModel = AppBarActionIconModel.WithData(
                    imageVector = checkIcon,
                    iconDescription = text,
                    iconClick = {}
                ),
                title = text
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = checkIcon,
                    contentDescription = text,
                )
            }
        }
    ) {
    }
}
