package com.quare.nuplist.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.domain.RootNavigation
import com.quare.nuplist.core.navigation.presentation.RootNavigationViewModel
import com.quare.nuplist.core.navigation.presentation.serializableType
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.feature.add_guest.AddGuestScreen
import com.quare.nuplist.feature.login.presentation.screen.LoginScreen
import com.quare.nuplist.feature.main.presentation.navhost.BottomNavHost
import com.quare.nuplist.feature.main.presentation.screen.MainScreen
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel
import com.quare.nuplist.ui.utils.back.BackNavigationMap
import com.quare.nuplist.ui.utils.back.BackNavigationType
import com.quare.nuplist.ui.utils.back.LocalBack
import org.koin.compose.viewmodel.koinViewModel
import kotlin.reflect.typeOf

@Composable
fun RootAppNavHost(getNavigationModifier: (onBack: () -> Unit) -> Modifier) {
    val viewmodel: RootNavigationViewModel = koinViewModel()
    val appNavController: NavHostController = rememberNavController()
    val bottomNavController: NavHostController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    ActionCollector(viewmodel.navigateChannel) { navigation ->
        when (navigation) {
            is RootNavigation.Login -> appNavController.navigate(NavRoute.Login)
            is RootNavigation.Main -> appNavController.navigate(NavRoute.Main(navigation.userModel))
        }
    }

    CompositionLocalProvider(LocalBack provides appNavController.getMapOfNavigationBack()) {
        NavHost(
            modifier = getNavigationModifier(appNavController::navigateUp),
            navController = appNavController,
            startDestination = NavRoute.Loading,
        ) {
            composable<NavRoute.Loading> {

            }
            composable<NavRoute.Login> {
                LoginScreen()
            }
            composable<NavRoute.Main>(
                typeMap = mapOf(
                    typeOf<UserModel>() to serializableType<UserModel>()
                )
            ) { mainBackStackEntry: NavBackStackEntry ->
                val arguments = mainBackStackEntry.toRoute<NavRoute.Main>()
                val mainViewModel: MainScreenViewModel = koinViewModel()
                MainScreen(
                    userModel = arguments.userModel,
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
