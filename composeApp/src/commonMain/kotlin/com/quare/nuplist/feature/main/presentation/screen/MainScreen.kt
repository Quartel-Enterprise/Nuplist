package com.quare.nuplist.feature.main.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.core.utils.ActionCollector
import com.quare.nuplist.feature.main.domain.MainScreenUiAction
import com.quare.nuplist.feature.main.domain.MainScreenUiEvent
import com.quare.nuplist.feature.main.presentation.viewmodel.MainScreenViewModel
import com.quare.nuplist.ui.dialog.profile.presentation.ProfileDialog
import com.quare.nuplist.ui.dialog.profile.presentation.model.LogoutModel

@Composable
fun MainScreen(
    userModel: UserModel,
    mainViewModel: MainScreenViewModel,
    navBackStackEntry: NavBackStackEntry?,
    goToBottomNavRoute: (Any) -> Unit,
    goToAddGuest: () -> Unit,
    bottomNavHost: @Composable (PaddingValues) -> Unit,
) {
    val onEvent = mainViewModel::dispatchUiEvent
    val state by mainViewModel.state.collectAsState()
    state.profileDialogUiState?.let {
        ProfileDialog(
            userModel = userModel,
            onDismiss = {
                onEvent(MainScreenUiEvent.DismissDialog)
            },
            logoutModel = LogoutModel(
                onClick = {
                    onEvent(MainScreenUiEvent.LogoutClick)
                },
                isLoading = it.isExitButtonLoading,
            )
        )
    }

    ActionCollector(mainViewModel.uiAction) { uiAction ->
        when (uiAction) {
            is MainScreenUiAction.NavigateToBottomRoute -> goToBottomNavRoute(uiAction.route)
            MainScreenUiAction.NavigateToAddGuest -> goToAddGuest()
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
