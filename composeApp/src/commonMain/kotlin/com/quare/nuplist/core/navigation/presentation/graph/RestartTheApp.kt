package com.quare.nuplist.core.navigation.presentation.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.ui.dialog.language_changed.LanguageChangeDialog

fun NavGraphBuilder.restartTheAppDialog(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    composable<NavRoute.RestartTheApp> { // Don't change to dialog<T> we need this to enforce the system reload the strings for while
        LanguageChangeDialog(
            modifier = modifier,
            onDismiss = navController::navigateUp,
        )
    }
}
