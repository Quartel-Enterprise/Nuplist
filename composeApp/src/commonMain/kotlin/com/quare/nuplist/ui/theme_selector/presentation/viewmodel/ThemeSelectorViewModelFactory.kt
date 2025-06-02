package com.quare.nuplist.ui.theme_selector.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.quare.nuplist.core.option.SelectableOption

@Composable
fun optionSelectorViewModel(
    optionSelected: SelectableOption,
    onOptionChange: (SelectableOption) -> Unit,
): OptionSelectorViewModel = viewModel(
    key = optionSelected.key,
    factory = viewModelFactory {
        initializer {
            OptionSelectorViewModel(
                optionSelected = optionSelected,
                onOptionSelected = onOptionChange,
            )
        }
    }
)
