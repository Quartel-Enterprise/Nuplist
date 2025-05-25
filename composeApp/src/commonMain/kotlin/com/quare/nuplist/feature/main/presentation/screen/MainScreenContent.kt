package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.quare.nuplist.feature.main.presentation.model.BottomNavHost
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.add_guest
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreenContent(
    currentDestination: NavDestination?,
    bottomNavHosts: List<BottomNavHost<Any>>,
    onItemClick: (Any) -> Unit,
    content: @Composable () -> Unit,
) {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            bottomNavHosts.forEach { bottomNavHost: BottomNavHost<Any> ->
                val presentationItem = bottomNavHost.presentationModel
                item(
                    selected = isSelected(currentDestination, bottomNavHost),
                    onClick = {
                        onItemClick(bottomNavHost.route)
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
                topBar = {

                },
                floatingActionButton = {
                    val text = stringResource(Res.string.add_guest)
                    ExtendedFloatingActionButton(
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = text,
                            )
                        },
                        text = { Text(text) },
                    )
                },
                modifier = Modifier.fillMaxSize()
            ) { paddingValues: PaddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        },
    )
}

private fun isSelected(
    currentDestination: NavDestination?,
    bottomNavHost: BottomNavHost<Any>,
): Boolean = currentDestination?.hierarchy?.any { navDestination: NavDestination ->
    navDestination.hasRoute(bottomNavHost.route::class)
} ?: false
