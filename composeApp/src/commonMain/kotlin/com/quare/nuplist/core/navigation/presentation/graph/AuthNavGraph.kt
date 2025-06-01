package com.quare.nuplist.core.navigation.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.quare.nuplist.core.navigation.domain.NavGraph
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation<NavGraph.Authentication>(
        startDestination = NavRoute.Login
    ) {
        composable<NavRoute.Login> {
            LoginScreen(
                goToSettings = {
                    navController.navigate(
                        NavRoute.Profile(
                            userModel = null,
                            showLogout = false
                        )
                    )
                }
            )
        }
    }
}
