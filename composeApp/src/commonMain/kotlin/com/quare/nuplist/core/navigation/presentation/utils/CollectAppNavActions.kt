package com.quare.nuplist.core.navigation.presentation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.quare.nuplist.core.navigation.domain.NavGraph
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
                is RootNavigation.Login -> {
                    popBackStack()
                    navigate(NavGraph.Authentication)
                }

                is RootNavigation.Main -> {
                    popBackStack()
                    navigate(NavRoute.Main(navigation.userModel))
                }
            }
        }
    }
}
