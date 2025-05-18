package com.quare.nuplist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.internationalization.presentation.InitializeLanguage
import com.quare.nuplist.core.navigation.RootAppNavHost
import com.quare.nuplist.core.theme.AppTheme

@Composable
fun App(specificColors: ColorScheme? = null) {
    AppTheme(specificColors) {
        InitializeLanguage()
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            RootAppNavHost()
        }
    }
}
