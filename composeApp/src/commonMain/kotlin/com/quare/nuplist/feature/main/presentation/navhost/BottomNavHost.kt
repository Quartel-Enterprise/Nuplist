package com.quare.nuplist.feature.main.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quare.nuplist.feature.guess_list.GuessListScreen
import com.quare.nuplist.feature.home.HomeScreen
import com.quare.nuplist.feature.main.presentation.model.BottomNavRoute
import com.quare.nuplist.feature.settings.presentation.SettingsScreen

@Composable
fun BottomNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavRoute.Home,
    ) {
        composable<BottomNavRoute.Home> {
            HomeScreen()
        }

        composable<BottomNavRoute.GuessList> {
            GuessListScreen()
        }

        composable<BottomNavRoute.Settings> {
            SettingsScreen()
        }
    }
}
