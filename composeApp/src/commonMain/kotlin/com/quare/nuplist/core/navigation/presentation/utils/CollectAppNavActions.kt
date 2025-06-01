package com.quare.nuplist.core.navigation.presentation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.quare.nuplist.core.navigation.domain.NavRoute
import com.quare.nuplist.core.navigation.domain.RootNavigation
import com.quare.nuplist.core.utils.ActionCollector
import kotlinx.coroutines.flow.Flow

@Composable
fun CollectAppNavActions(
    appNavController: NavHostController,
    navigationActions: Flow<RootNavigation>,
) {
    appNavController.run {
        ActionCollector(navigationActions) { navigation ->
            when (navigation) {
                is RootNavigation.Login -> navigateDroppingAll(NavRoute.Login)
                is RootNavigation.Main -> navigateDroppingAll(NavRoute.Main(navigation.userModel))
            }
        }
    }
}

private fun NavController.navigateDroppingAll(route: Any) {
    navigate(route) {
        popUpTo(0) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = false
    }
}
