package com.quare.nuplist.core.config

import io.github.jan.supabase.auth.AuthConfig

actual fun AuthConfig.platformAuthConfig() {
    httpCallbackConfig {
        this.redirectHtml = getSuccessAuthHtml(
            icon = "",
            title = "Nuplist",
            text = "You're already logged in, you can close this tab now"
        )
    }
}

private fun getSuccessAuthHtml(icon: String, title: String, text: String): String = """
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>$title</title>
        <link rel="icon" href="$icon">
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
        <style>
            body {
                margin: 0;
                background: linear-gradient(135deg, #1e1f24, #2f3237);
                color: #ffffff;
                font-family: 'Inter', sans-serif;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                text-align: center;
            }

            .message-container {
                max-width: 90%;
                padding: 2rem;
                background-color: rgba(255, 255, 255, 0.05);
                border-radius: 12px;
                box-shadow: 0 8px 24px rgba(0, 0, 0, 0.3);
                animation: fadeIn 0.8s ease-in-out;
            }

            h1 {
                font-size: 2.25rem;
                margin-bottom: 1rem;
            }

            p {
                font-size: 1.25rem;
                opacity: 0.85;
            }

            @keyframes fadeIn {
                from {
                    opacity: 0;
                    transform: translateY(10px);
                }
                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }
        </style>
    </head>
    <body>
        <div class="message-container">
            <h1>$title</h1>
            <p>$text</p>
        </div>
        <script>
            const newURL = location.href.split("?")[0];
            window.history.replaceState({}, document.title, newURL);
        </script>
    </body>
    </html>
""".trimIndent()
