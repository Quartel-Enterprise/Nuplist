package com.quare.nuplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.quare.nuplist.app.presentation.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            enableEdgeToEdge()
            App(
                getSpecificColors = { getAndroidSpecificColorScheme(it) }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
