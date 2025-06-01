package com.quare.nuplist.core.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.graph.authNavGraph
import com.quare.nuplist.core.navigation.presentation.graph.mainNavGraph
import com.quare.nuplist.core.navigation.presentation.graph.profileNavGraph
import com.quare.nuplist.core.navigation.presentation.utils.CollectAppNavActions
import com.quare.nuplist.core.navigation.presentation.viewmodel.RootNavigationViewModel
import com.quare.nuplist.ui.utils.back.BackNavigationMap
import com.quare.nuplist.ui.utils.back.BackNavigationType
import com.quare.nuplist.ui.utils.back.LocalBack
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RootAppNavHost(getNavigationModifier: (onBack: () -> Unit) -> Modifier) {
    val viewmodel: RootNavigationViewModel = koinViewModel()
    val appNavController: NavHostController = rememberNavController()
    CollectAppNavActions(
        appNavController = appNavController,
        navigationActions = viewmodel.navigateChannel,
    )

    CompositionLocalProvider(LocalBack provides appNavController.getMapOfNavigationBack()) {
        NavHost(
            modifier = getNavigationModifier(appNavController::navigateUp),
            navController = appNavController,
            startDestination = NavRoute.Loading,
        ) {
            authNavGraph(appNavController)
            mainNavGraph(
                appNavController = appNavController,
                getNavigationModifier = getNavigationModifier
            )
            profileNavGraph(appNavController)
            composable<NavRoute.Loading> {}
        }
    }
}


private fun NavController.getMapOfNavigationBack(): BackNavigationMap = mapOf(
    BackNavigationType.NORMAL to { navigateUp() },
    BackNavigationType.NONE to {}
)
