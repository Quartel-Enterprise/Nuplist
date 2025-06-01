package com.quare.nuplist.core.navigation.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable<NavRoute.Login> {
        LoginScreen(
            goToSettings = navController::goToSettings
        )
    }
}

private fun NavController.goToSettings() {
    navigate(
        NavRoute.Profile(
            userModel = null,
            shouldShowLogout = false
        )
    )
}
