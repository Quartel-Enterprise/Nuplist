package com.quare.nuplist.di

import com.quare.nuplist.core.config.configModule
import com.quare.nuplist.core.navigation.di.navigationModule
import com.quare.nuplist.feature.di.loginModule
import com.quare.nuplist.feature.main.di.mainModule
import com.quare.nuplist.feature.settings.di.settingsModule
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.core.module.Module

expect val platformModule: Module

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            configModule,
            mainModule,
            loginModule,
            navigationModule,
            settingsModule,
        )
    }
}

fun provideSupabaseAuthDeeplinkHandler(): SupabaseAuthDeeplinkHandler {
    val koinComponent = object : KoinComponent {
        val supabaseAuthDeeplinkHandler: SupabaseAuthDeeplinkHandler get() = get()
    }
    return koinComponent.supabaseAuthDeeplinkHandler
}
