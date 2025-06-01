package com.quare.nuplist.feature.main.domain

sealed interface MainScreenUiAction {
    data class NavigateToBottomRoute(val route: Any) : MainScreenUiAction
    data object NavigateToAddGuest : MainScreenUiAction
    data object NavigateToProfile : MainScreenUiAction
}
