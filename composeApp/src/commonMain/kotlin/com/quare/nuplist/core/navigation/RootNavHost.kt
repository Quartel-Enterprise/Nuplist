package com.quare.nuplist.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.quare.nuplist.core.navigation.domain.RootNavigation
import com.quare.nuplist.core.navigation.presentation.RootNavigationViewModel
import com.quare.nuplist.feature.login.presentation.screen.LoginScreen
import com.quare.nuplist.feature.main.presentation.screen.MainScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RootAppNavHost() {
    val viewmodel: RootNavigationViewModel = koinViewModel()
    val firstScreen by viewmodel.firstScreen.collectAsState()
    when (firstScreen) {
        RootNavigation.Loading -> Unit
        RootNavigation.Login -> LoginScreen()
        RootNavigation.Main -> MainScreen()
    }
}
