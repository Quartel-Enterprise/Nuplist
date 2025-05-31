package com.quare.nuplist.core.navigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.feature.add_guest.AddGuestScreen
import com.quare.nuplist.feature.main.presentation.navhost.BottomNavHost
import com.quare.nuplist.feature.main.presentation.screen.MainScreen
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel
import com.quare.nuplist.ui.utils.back.BackNavigationMap
import com.quare.nuplist.ui.utils.back.BackNavigationType
import com.quare.nuplist.ui.utils.back.LocalBack
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavHost(userModel: UserModel, getNavigationModifier: (onBack: () -> Unit) -> Modifier) {
    val appNavController: NavHostController = rememberNavController()
    val bottomNavController: NavHostController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    CompositionLocalProvider(LocalBack provides appNavController.getMapOfNavigationBack()) {
        NavHost(
            modifier = getNavigationModifier(appNavController::navigateUp),
            navController = appNavController,
            startDestination = NavRoute.Main,
        ) {
            composable<NavRoute.Main> {
                val mainViewModel: MainScreenViewModel = koinViewModel()
                MainScreen(
                    userModel = userModel,
                    mainViewModel = mainViewModel,
                    navBackStackEntry = navBackStackEntry,
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

private fun NavController.getMapOfNavigationBack(): BackNavigationMap = mapOf(
    BackNavigationType.NORMAL to { navigateUp() },
    BackNavigationType.NONE to {}
)
