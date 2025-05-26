package com.quare.nuplist.feature.main.domain

sealed interface MainScreenUiEvent {
    data class BottomNavItemClicked(val route: Any): MainScreenUiEvent
    data object AddGuestClicked: MainScreenUiEvent
    data object ProfilePictureClicked: MainScreenUiEvent
}
