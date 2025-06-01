package com.quare.nuplist.core.navigation.presentation.graph

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.quare.nuplist.core.navigation.domain.NavGraph
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.utils.serializableType
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.ui.dialog.profile.presentation.ProfileDialog
import kotlin.reflect.typeOf

fun NavGraphBuilder.profileNavGraph(navController: NavController) {
    navigation<NavGraph.Profile>(
        startDestination = NavRoute.Profile(null, false)
    ) {
        dialog<NavRoute.Profile>(
            typeMap = mapOf(
                typeOf<UserModel?>() to serializableType<UserModel?>()
            )
        ) { backStackEntry: NavBackStackEntry ->
            val arguments = backStackEntry.toRoute<NavRoute.Profile>()
            ProfileDialog(
                userModel = arguments.userModel,
                showLogout = arguments.showLogout,
                onDismiss = navController::navigateUp,
            )
        }
    }
}
