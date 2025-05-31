package com.quare.nuplist.feature.main.presentation.navhost

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quare.nuplist.feature.guess_list.GuessListScreen
import com.quare.nuplist.feature.home.HomeScreen
import com.quare.nuplist.feature.main.presentation.model.BottomNavRoute

@Composable
fun BottomNavHost(
    paddingValues: PaddingValues,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        navController = navController,
        startDestination = BottomNavRoute.Home,
    ) {
        composable<BottomNavRoute.Home> {
            HomeScreen()
        }

        composable<BottomNavRoute.GuessList> {
            GuessListScreen()
        }
    }
}
