package com.quare.nuplist.core.navigation.domain

import kotlinx.serialization.Serializable

sealed interface NavGraph {

    @Serializable
    data object Main : NavGraph

    @Serializable
    data object Authentication : NavGraph

    @Serializable
    data object Profile: NavGraph
}
