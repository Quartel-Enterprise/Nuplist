package com.quare.nuplist.core.navigation.domain

import com.quare.nuplist.core.user.domain.model.UserModel

sealed interface RootNavigation {
    data object Login : RootNavigation
    data class Main(val userModel: UserModel) : RootNavigation
}
