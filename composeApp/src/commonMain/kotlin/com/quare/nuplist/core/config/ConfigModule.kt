package com.quare.nuplist.core.config

import com.quare.nuplist.BuildKonfig
import com.quare.nuplist.app.domain.GetLanguageOptionUseCase
import com.quare.nuplist.app.domain.GetThemeOptionUseCase
import com.quare.nuplist.app.presentation.AppViewModel
import com.quare.nuplist.ui.dialog.profile.presentation.ProfileDialogViewModel
import com.quare.nuplist.ui.dialog.logout.presentation.LogoutViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.AuthConfig
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.googleNativeLogin
import io.github.jan.supabase.createSupabaseClient
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect fun AuthConfig.platformAuthConfig()

val configModule = module {
    factory {
        ApplicationTokens(
            supabaseUrl = BuildKonfig.SUPABASE_URL,
            supabaseApiKey = BuildKonfig.SUPABASE_API_KEY,
            webGoogleClientId = BuildKonfig.WEB_GOOGLE_CLIENT_ID,
        )
    }
    single<SupabaseClient> {
        val applicationTokens: ApplicationTokens = get()
        createSupabaseClient(
            supabaseUrl = applicationTokens.supabaseUrl,
            supabaseKey = applicationTokens.supabaseApiKey,
        ) {
            install(Auth) {
                platformAuthConfig()
            }
            install(ComposeAuth) {
                googleNativeLogin(serverClientId = applicationTokens.webGoogleClientId)
            }
        }
    }
    factory {
        GetThemeOptionUseCase()
    }
    factory {
        GetLanguageOptionUseCase()
    }
    viewModelOf(::AppViewModel)
    viewModelOf(::ProfileDialogViewModel)
    viewModelOf(::LogoutViewModel)
}
