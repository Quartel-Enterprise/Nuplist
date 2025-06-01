package com.quare.nuplist.core.navigation.presentation.graph

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.quare.nuplist.core.navigation.domain.NavGraph
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.presentation.utils.serializableType
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.feature.add_guest.AddGuestScreen
import com.quare.nuplist.feature.main.presentation.navhost.BottomNavHost
import com.quare.nuplist.feature.main.presentation.screen.MainScreen
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel
import org.koin.compose.viewmodel.koinViewModel
import kotlin.reflect.typeOf

fun NavGraphBuilder.mainNavGraph(
    appNavController: NavHostController,
    getNavigationModifier: (onBack: () -> Unit) -> Modifier,
) {
    navigation<NavGraph.Main>(
        startDestination = NavRoute.Main(null),
    ) {
        composable<NavRoute.Main>(
            typeMap = mapOf(
                typeOf<UserModel?>() to serializableType<UserModel?>()
            )
        ) { mainBackStackEntry: NavBackStackEntry ->
            val bottomNavController: NavHostController = rememberNavController()
            val bottomNavBackStackEntry by bottomNavController.currentBackStackEntryAsState()
            val arguments = mainBackStackEntry.toRoute<NavRoute.Main>()
            val mainViewModel: MainScreenViewModel = koinViewModel()
            MainScreen(
                userModel = arguments.userModel ?: return@composable,
                mainViewModel = mainViewModel,
                navBackStackEntry = bottomNavBackStackEntry,
                goToBottomNavRoute = bottomNavController::goToBottomNavRoute,
                goToAddGuest = {
                    appNavController.navigate(NavRoute.AddGuest)
                },
                bottomNavHost = {
                    BottomNavHost(
                        modifier = getNavigationModifier(bottomNavController::navigateUp),
                        paddingValues = it,
                        navController = bottomNavController
                    )
                },
                goToProfile = {
                    appNavController.navigate(
                        NavRoute.Profile(
                            userModel = arguments.userModel,
                            shouldShowLogout = true,
                        )
                    )
                }
            )
        }
        composable<NavRoute.AddGuest> {
            AddGuestScreen(
                back = {
                    appNavController.navigateUp()
                }
            )
        }
    }
}

private fun NavHostController.goToBottomNavRoute(route: Any) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
