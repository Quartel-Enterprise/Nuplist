package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import co.touchlab.kermit.Logger
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.feature.main.domain.MainScreenUiEvent
import com.quare.nuplist.feature.main.presentation.model.BottomNavRoute
import com.quare.nuplist.feature.main.presentation.model.BottomNavigationItemModel
import com.quare.nuplist.feature.main.presentation.screen.component.MainAppBarComponent
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.add_guest
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreenContent(
    userModel: UserModel,
    currentDestination: NavDestination?,
    bottomNavigationModels: List<BottomNavigationItemModel<Any>>,
    onEvent: (MainScreenUiEvent) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            bottomNavigationModels.forEach { bottomNavigationItemModel: BottomNavigationItemModel<Any> ->
                val presentationItem = bottomNavigationItemModel.presentationModel
                val isSelected = isSelected(currentDestination, bottomNavigationItemModel)
                item(
                    selected = isSelected,
                    onClick = {
                        onEvent(
                            MainScreenUiEvent.BottomNavItemClicked(
                                bottomNavigationItemModel.route,
                            )
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = presentationItem.icon,
                            contentDescription = stringResource(presentationItem.title)
                        )
                    },
                    label = {
                        Text(stringResource(presentationItem.title))
                    },
                )
            }
        },
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    MainAppBarComponent(
                        userPhoto = userModel.photo,
                        onEvent = onEvent,
                    )
                },
                floatingActionButton = {
                    val text = stringResource(Res.string.add_guest)
                    ExtendedFloatingActionButton(
                        onClick = {
                            onEvent(MainScreenUiEvent.AddGuestClicked)
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = text,
                            )
                        },
                        text = { Text(text) },
                    )
                },
                content = content,
            )
        },
    )
}

private fun isSelected(
    currentDestination: NavDestination?,
    bottomNavigationItemModel: BottomNavigationItemModel<Any>,
): Boolean {
    Logger.d(tag = "isSelected", messageString = "currentDestination: $currentDestination")
    Logger.d(tag = "isSelected", messageString = "bottomNavigationItemModel: $bottomNavigationItemModel")
    return currentDestination?.hierarchy
        ?.any { navDestination: NavDestination ->
            (bottomNavigationItemModel.route as? BottomNavRoute)?.let { route ->
                navDestination.hasRoute(route::class)
            } ?: false
        } ?: false
}
