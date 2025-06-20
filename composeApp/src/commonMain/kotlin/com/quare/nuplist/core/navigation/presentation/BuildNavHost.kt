package com.quare.nuplist.core.navigation.presentation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.graph.addGuestScreen
import com.quare.nuplist.core.navigation.presentation.graph.loginScreen
import com.quare.nuplist.core.navigation.presentation.graph.logoutDialog
import com.quare.nuplist.core.navigation.presentation.graph.mainScreen
import com.quare.nuplist.core.navigation.presentation.graph.profileDialog
import com.quare.nuplist.core.navigation.presentation.graph.restartTheAppDialog

fun NavGraphBuilder.buildNavHost(
    appNavController: NavHostController,
    getNavigationModifier: (onBack: () -> Unit) -> Modifier,
) {
    val dialogModifier = getNavigationModifier(appNavController::navigateUp)
    loginScreen(appNavController)
    mainScreen(
        appNavController = appNavController,
        getNavigationModifier = getNavigationModifier,
    )
    addGuestScreen(appNavController)
    profileDialog(
        navController = appNavController,
        modifier = dialogModifier
    )
    logoutDialog(
        navController = appNavController,
        modifier = dialogModifier
    )
    restartTheAppDialog(
        modifier = dialogModifier,
        navController = appNavController,
    )
    composable<NavRoute.Loading> {}
}
