package com.quare.nuplist.core.navigation.domain

import com.quare.nuplist.core.user.domain.model.UserModel
import kotlinx.serialization.Serializable

sealed interface NavRoute {

    @Serializable
    data object Loading: NavRoute

    @Serializable
    data object Login: NavRoute

    @Serializable
    data class Main(val userModel: UserModel): NavRoute

    @Serializable
    data object AddGuest: NavRoute
}
