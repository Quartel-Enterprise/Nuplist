package com.quare.nuplist.di

import com.quare.nuplist.core.internationalization.domain.Localization
import com.quare.nuplist.core.supabase.IosSupabaseAuthDeeplinkHandler
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<Localization> { Localization() }

    factory<SupabaseAuthDeeplinkHandler> {
        IosSupabaseAuthDeeplinkHandler(get())
    }
}
