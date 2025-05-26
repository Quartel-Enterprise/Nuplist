package com.quare.nuplist.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.quare.nuplist.core.navigation.domain.RootNavigation
import com.quare.nuplist.core.navigation.presentation.AppNavHost
import com.quare.nuplist.core.navigation.presentation.RootNavigationViewModel
import com.quare.nuplist.feature.login.presentation.screen.LoginScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RootAppNavHost() {
    val viewmodel: RootNavigationViewModel = koinViewModel()
    val firstScreen by viewmodel.firstScreen.collectAsState()
    RootAppNavHostContent(firstScreen)
}

@Composable
private fun RootAppNavHostContent(firstScreen: RootNavigation) {
    when (firstScreen) {
        RootNavigation.Loading -> Unit
        RootNavigation.Login -> LoginScreen()
        is RootNavigation.Main -> AppNavHost(firstScreen.userModel)
    }
}
