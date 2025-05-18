package com.quare.nuplist.feature.main.presentation.model

import kotlinx.serialization.Serializable

sealed interface MainNavRoute {

    @Serializable
    data object Home: MainNavRoute

    @Serializable
    data object GuessList: MainNavRoute

    @Serializable
    data object Settings: MainNavRoute
}
