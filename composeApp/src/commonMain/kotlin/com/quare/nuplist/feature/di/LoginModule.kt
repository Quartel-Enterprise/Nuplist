package com.quare.nuplist.feature.di

import com.quare.nuplist.feature.login.data.mapper.SessionUserMapper
import com.quare.nuplist.feature.login.presentation.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    factory {
        SessionUserMapper()
    }
    viewModelOf(::LoginViewModel)
}
