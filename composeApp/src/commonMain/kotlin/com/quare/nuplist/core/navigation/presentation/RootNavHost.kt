package com.quare.nuplist.core.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.graph.addGuestScreen
import com.quare.nuplist.core.navigation.presentation.graph.loginScreen
import com.quare.nuplist.core.navigation.presentation.graph.logoutDialog
import com.quare.nuplist.core.navigation.presentation.graph.mainScreen
import com.quare.nuplist.core.navigation.presentation.graph.profileDialog
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
            builder = {
                buildNavHost(appNavController, getNavigationModifier)
            }
        )
    }
}

private fun NavGraphBuilder.buildNavHost(
    appNavController: NavHostController,
    getNavigationModifier: (onBack: () -> Unit) -> Modifier,
) {
    loginScreen(appNavController)
    mainScreen(
        appNavController = appNavController,
        getNavigationModifier = getNavigationModifier,
    )
    addGuestScreen(appNavController)
    profileDialog(
        navController = appNavController,
        modifier = getNavigationModifier(appNavController::navigateUp)
    )
    logoutDialog(
        navController = appNavController,
        modifier = getNavigationModifier(appNavController::navigateUp)
    )
    composable<NavRoute.Loading> {}
}


private fun NavController.getMapOfNavigationBack(): BackNavigationMap = mapOf(
    BackNavigationType.NORMAL to { navigateUp() },
    BackNavigationType.NONE to {}
)
