package com.quare.nuplist.core.navigation.presentation.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.ui.dialog.logout.presentation.LogoutDialog

fun NavGraphBuilder.logoutDialog(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    dialog<NavRoute.Logout> {
        LogoutDialog(
            modifier = modifier,
            onDismiss = navController::navigateUp
        )
    }
}
