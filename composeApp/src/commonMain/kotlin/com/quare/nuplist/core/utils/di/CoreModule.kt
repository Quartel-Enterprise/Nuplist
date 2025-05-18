package com.quare.nuplist.core.utils.di

import com.quare.nuplist.core.config.ApplicationTokens
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.googleNativeLogin
import io.github.jan.supabase.createSupabaseClient
import org.koin.dsl.module

val utilsModule = module {
    single<SupabaseClient> {
        val applicationTokens: ApplicationTokens = get()
        createSupabaseClient(
            supabaseUrl = applicationTokens.supabaseUrl,
            supabaseKey = applicationTokens.supabaseApiKey,
        ) {
            install(Auth)
            install(ComposeAuth) {
                googleNativeLogin(serverClientId = applicationTokens.webGoogleClientId)
            }
        }
    }
}
