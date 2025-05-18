package com.quare.nuplist.core.supabase

import com.quare.nuplist.di.SupabaseAuthDeeplinkHandler
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.handleDeeplinks
import platform.Foundation.NSURL

class IosSupabaseAuthDeeplinkHandler(
    private val supabaseClient: SupabaseClient
): SupabaseAuthDeeplinkHandler {
    override fun handle(url: String) {
        supabaseClient.handleDeeplinks(NSURL(string = url))
    }
}
