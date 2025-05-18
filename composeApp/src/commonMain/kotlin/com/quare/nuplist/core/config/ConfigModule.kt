package com.quare.nuplist.core.config

import com.quare.nuplist.BuildKonfig
import org.koin.dsl.module

val configModule = module {
    factory {
        ApplicationTokens(
            supabaseUrl = BuildKonfig.SUPABASE_URL,
            supabaseApiKey = BuildKonfig.SUPABASE_API_KEY,
            webGoogleClientId = BuildKonfig.WEB_GOOGLE_CLIENT_ID,
        )
    }
}
