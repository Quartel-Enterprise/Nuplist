package com.quare.nuplist.core.navigation.presentation.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import androidx.navigation.toRoute
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.utils.serializableType
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.ui.dialog.profile.presentation.ProfileDialog
import kotlin.reflect.typeOf

fun NavGraphBuilder.profileDialog(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    dialog<NavRoute.Profile>(
        typeMap = mapOf(
            typeOf<UserModel?>() to serializableType<UserModel?>()
        )
    ) { backStackEntry: NavBackStackEntry ->
        val arguments = backStackEntry.toRoute<NavRoute.Profile>()
        navController.run {
            ProfileDialog(
                modifier = modifier,
                onLogoutClick = {
                    popBackStack()
                    navigate(NavRoute.Logout)
                },
                userModel = arguments.userModel,
                shouldShowLogout = arguments.shouldShowLogout,
                onDismiss = ::navigateUp,
            )
        }
    }
}
