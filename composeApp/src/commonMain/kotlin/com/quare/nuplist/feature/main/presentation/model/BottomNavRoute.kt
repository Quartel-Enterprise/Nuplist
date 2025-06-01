package com.quare.nuplist.feature.main.presentation.model

import kotlinx.serialization.Serializable

sealed interface BottomNavRoute {

    @Serializable
    data object Home : BottomNavRoute

    @Serializable
    data object GuessList : BottomNavRoute

    @Serializable
    data object Event : BottomNavRoute
}
