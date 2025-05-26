package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.feature.main.domain.MainScreenUiAction
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    userModel: UserModel,
    mainViewModel: MainScreenViewModel,
    navBackStackEntry: NavBackStackEntry?,
    goToBottomNavRoute: (Any) -> Unit,
    goToAddGuest: () -> Unit,
    bottomNavHost: @Composable () -> Unit,
) {
    ActionCollector(mainViewModel.uiAction) { uiAction ->
        when (uiAction) {
            is MainScreenUiAction.NavigateToBottomRoute -> goToBottomNavRoute(uiAction.route)
            MainScreenUiAction.NavigateToAddGuest -> goToAddGuest()
        }
    }
    MainScreenContent(
        currentDestination = navBackStackEntry?.destination,
        bottomNavigationModels = mainViewModel.bottomNavigationItemModels,
        onEvent = mainViewModel::dispatchUiEvent,
        content = bottomNavHost,
        userModel = userModel,
    )
}
