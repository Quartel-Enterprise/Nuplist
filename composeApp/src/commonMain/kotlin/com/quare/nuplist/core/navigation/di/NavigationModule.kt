package com.quare.nuplist.core.navigation.di

import com.quare.nuplist.core.navigation.presentation.viewmodel.RootNavigationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val navigationModule = module {
    viewModelOf(::RootNavigationViewModel)
}
