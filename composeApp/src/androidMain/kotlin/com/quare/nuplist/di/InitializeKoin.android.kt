package com.quare.nuplist.di

import com.quare.nuplist.core.internationalization.domain.Localization
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<Localization> { Localization(context = androidContext()) }
}
