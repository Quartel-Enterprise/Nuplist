package com.quare.nuplist.feature.main.presentation.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.quare.nuplist.feature.main.presentation.model.BottomNavigationItemPresentationModel
import com.quare.nuplist.feature.main.presentation.model.MainNavRoute
import com.quare.nuplist.feature.main.presentation.model.TopLevelRoute
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.guest_list
import nuplist.composeapp.generated.resources.home
import nuplist.composeapp.generated.resources.settings

class MainScreenViewModel : ViewModel() {

    private val routes: List<MainNavRoute> = listOf(
        MainNavRoute.Home,
        MainNavRoute.GuessList,
        MainNavRoute.Settings,
    )

    val topLevelRoutes: List<TopLevelRoute<Any>> = routes.map { it.toTopLevelRoute() }

    private fun MainNavRoute.toTopLevelRoute(): TopLevelRoute<Any> = TopLevelRoute(
        route = this,
        presentationModel = when (this) {
            MainNavRoute.Home -> BottomNavigationItemPresentationModel(
                title = Res.string.home,
                icon = Icons.Default.Home,
            )

            MainNavRoute.GuessList -> BottomNavigationItemPresentationModel(
                title = Res.string.guest_list,
                icon = Icons.AutoMirrored.Default.List,
            )

            MainNavRoute.Settings -> BottomNavigationItemPresentationModel(
                title = Res.string.settings,
                icon = Icons.Default.Settings
            )
        }
    )
}
