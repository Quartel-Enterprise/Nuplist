package com.quare.nuplist.app.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.quare.nuplist.core.navigation.presentation.RootAppNavHost
import com.quare.nuplist.core.option.LocalLanguageOption
import com.quare.nuplist.core.option.LocalOptionChange
import com.quare.nuplist.core.option.LocalThemeOption
import com.quare.nuplist.core.option.SelectableOption
import com.quare.nuplist.core.option.SelectedOptions
import com.quare.nuplist.ui.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(
    getNavigationModifier: (onBack: () -> Unit) -> Modifier = { Modifier },
    getSpecificColors: @Composable ((isAppInDarkTheme: Boolean) -> ColorScheme?)? = null,
) {
    val viewModel: AppViewModel = koinViewModel()
    val selectableOptions by viewModel.selectableOptions.collectAsState()
    selectableOptions?.let { safeOptions: SelectedOptions ->
        ProvideCompositionLocals(
            selectedOptions = safeOptions,
            onOptionChange = viewModel::onOptionChange,
        ) {
            AppTheme(getSpecificColors) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    RootAppNavHost(getNavigationModifier)
                }
            }
        }
    }
}

@Composable
private fun ProvideCompositionLocals(
    selectedOptions: SelectedOptions,
    onOptionChange: (SelectableOption) -> Unit,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemeOption provides selectedOptions.theme,
        LocalLanguageOption provides selectedOptions.language,
        LocalOptionChange provides onOptionChange,
    ) {
        content()
    }
}
