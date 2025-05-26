package com.quare.nuplist.core.navigation.domain

import kotlinx.serialization.Serializable

sealed interface NavRoute {

    @Serializable
    data object Main: NavRoute

    @Serializable
    data object AddGuest: NavRoute
}
