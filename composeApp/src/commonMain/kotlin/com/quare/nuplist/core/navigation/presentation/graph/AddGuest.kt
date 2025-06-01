package com.quare.nuplist.core.navigation.presentation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.feature.add_guest.AddGuestScreen

fun NavGraphBuilder.addGuestScreen(
    appNavController: NavHostController,
) {
    composable<NavRoute.AddGuest> {
        AddGuestScreen(
            back = {
                appNavController.navigateUp()
            }
        )
    }
}
