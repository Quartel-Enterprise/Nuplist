package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quare.nuplist.feature.main.presentation.navhost.MainNavHost
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    mainViewModel: MainScreenViewModel = koinViewModel(),
) {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    MainScreenContent(
        currentDestination = navBackStackEntry?.destination,
        topLevelRoutes = mainViewModel.topLevelRoutes,
        onItemClick = navController::onItemClick,
        content = {
            MainNavHost(navController)
        }
    )
}

private fun NavHostController.onItemClick(route: Any) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}


