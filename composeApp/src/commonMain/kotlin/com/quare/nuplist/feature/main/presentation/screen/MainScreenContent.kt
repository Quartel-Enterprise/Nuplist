package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.quare.nuplist.feature.main.presentation.model.TopLevelRoute
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreenContent(
    currentDestination: NavDestination?,
    topLevelRoutes: List<TopLevelRoute<Any>>,
    onItemClick: (Any) -> Unit,
    content: @Composable () -> Unit,
) {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            topLevelRoutes.forEach { topLevelRoute: TopLevelRoute<Any> ->
                val presentationItem = topLevelRoute.presentationModel
                item(
                    selected = isSelected(currentDestination, topLevelRoute),
                    onClick = {
                        onItemClick(topLevelRoute.route)
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
            Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues: PaddingValues ->
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
    topLevelRoute: TopLevelRoute<Any>,
): Boolean = currentDestination?.hierarchy?.any { navDestination: NavDestination ->
    navDestination.hasRoute(topLevelRoute.route::class)
} ?: false
