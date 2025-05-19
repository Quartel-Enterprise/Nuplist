package com.quare.nuplist.app.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.internationalization.presentation.InitializeLanguage
import com.quare.nuplist.core.navigation.RootAppNavHost
import com.quare.nuplist.core.theme.AppTheme
import com.quare.nuplist.core.theme.LocalThemeChanged
import com.quare.nuplist.core.theme.LocalThemeOption
import com.quare.nuplist.core.theme.ThemeOption
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(
    getSpecificColors: @Composable ((isAppInDarkTheme: Boolean) -> ColorScheme?)? = null
) {
    val viewModel: AppViewModel = koinViewModel()
    val themeOption by viewModel.themeOption.collectAsState()
    themeOption?.let { safeThemeOption ->
        ProvideCompositionLocals(
            themeOption = safeThemeOption,
            onThemeChanged = viewModel::onThemeChange,
        ) {
            AppTheme(getSpecificColors) {
                InitializeLanguage()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RootAppNavHost()
                }
            }
        }
    }
}

@Composable
private fun ProvideCompositionLocals(
    themeOption: ThemeOption,
    onThemeChanged: (ThemeOption) -> Unit,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemeOption provides themeOption,
        LocalThemeChanged provides onThemeChanged,
    ) {
        content()
    }
}
