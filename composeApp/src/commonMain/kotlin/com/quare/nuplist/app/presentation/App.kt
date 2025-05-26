package com.quare.nuplist.app.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.navigation.RootAppNavHost
import com.quare.nuplist.core.option.LocalOptionChange
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.core.theme.AppTheme
import com.quare.nuplist.core.option.LocalThemeOption
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(
    getSpecificColors: @Composable ((isAppInDarkTheme: Boolean) -> ColorScheme?)? = null
) {
    val viewModel: AppViewModel = koinViewModel()
    val selectableOptions by viewModel.selectableOptions.collectAsState()
    selectableOptions?.let { safeOptions ->
        ProvideCompositionLocals(
            themeOption = safeOptions.theme,
            onOptionChange = viewModel::onOptionChange,
        ) {
            AppTheme(getSpecificColors) {
//                InitializeLanguage()
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
    themeOption: SelectableOption.Theme,
    onOptionChange: (SelectableOption) -> Unit,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemeOption provides themeOption,
        LocalOptionChange provides onOptionChange,
    ) {
        content()
    }
}
