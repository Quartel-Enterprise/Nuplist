package com.quare.nuplist.feature.main.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quare.nuplist.feature.guess_list.GuessListScreen
import com.quare.nuplist.feature.home.HomeScreen
import com.quare.nuplist.feature.main.presentation.model.MainNavRoute
import com.quare.nuplist.feature.settings.presentation.SettingsScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainNavRoute.Home,
    ) {
        composable<MainNavRoute.Home> {
            HomeScreen()
        }

        composable<MainNavRoute.GuessList> {
            GuessListScreen()
        }

        composable<MainNavRoute.Settings> {
            SettingsScreen()
        }
    }
}
