package com.quare.nuplist.core.config

import io.github.jan.supabase.auth.AuthConfig

actual fun AuthConfig.platformAuthConfig() {

    httpCallbackConfig {
        this.redirectHtml = getSuccessAuthHtml()
    }
}

private fun getSuccessAuthHtml(): String {
    val prefix = "com/quare/nuplist/presentation"
    val htmlTemplate: String = loadResourceAsText("$prefix/auth_success_template.html")
    val css = loadResourceAsText("$prefix/auth_success_template_dark.css")

    return htmlTemplate
        .replace(
            oldValue = """<link rel="stylesheet" href="auth_success_template_dark.css">""",
            newValue = "<style>\n$css\n</style>"
        )
        .replace(
            oldValue = "{{ICON}}",
            newValue = ""
        )
        .replace(
            oldValue = "{{TITLE}}",
            newValue = "Nuplist"
        )
        .replace(
            oldValue = "{{TEXT}}",
            newValue = "You're already logged in, you can close this tab now"
        )
}

private fun loadResourceAsText(path: String): String {
    val classLoader: ClassLoader = Thread.currentThread().contextClassLoader
    return classLoader
        .getResourceAsStream(path)
        ?.reader(Charsets.UTF_8)
        ?.readText()
        ?: error("Resource not found: $path")
}
