package com.quare.nuplist.feature.main.presentation.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.quare.nuplist.feature.main.domain.MainScreenUiEvent
import com.quare.nuplist.feature.main.presentation.model.BottomNavigationItemPresentationModel
import com.quare.nuplist.feature.main.presentation.model.MainNavRoute
import com.quare.nuplist.feature.main.presentation.model.BottomNavHost
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

    val bottomNavHosts: List<BottomNavHost<Any>> = routes.map { it.toBottomNavHost() }

    fun dispatchUiEvent(event: MainScreenUiEvent) {

    }

    private fun MainNavRoute.toBottomNavHost(): BottomNavHost<Any> = BottomNavHost(
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
