package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
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
    goToProfile: () -> Unit,
    bottomNavHost: @Composable (PaddingValues) -> Unit,
) {
    val onEvent = mainViewModel::dispatchUiEvent

    ActionCollector(mainViewModel.uiAction) { uiAction ->
        when (uiAction) {
            is MainScreenUiAction.NavigateToBottomRoute -> goToBottomNavRoute(uiAction.route)
            MainScreenUiAction.NavigateToAddGuest -> goToAddGuest()
            MainScreenUiAction.NavigateToProfile -> goToProfile()
        }
    }
    MainScreenContent(
        currentDestination = navBackStackEntry?.destination,
        bottomNavigationModels = mainViewModel.bottomNavigationItemModels,
        onEvent = onEvent,
        content = bottomNavHost,
        userModel = userModel,
    )
}
