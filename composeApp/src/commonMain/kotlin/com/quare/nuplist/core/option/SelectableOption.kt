package com.quare.nuplist.core.option

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.ui.graphics.vector.ImageVector
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.dark
import nuplist.composeapp.generated.resources.english
import nuplist.composeapp.generated.resources.language
import nuplist.composeapp.generated.resources.light
import nuplist.composeapp.generated.resources.portuguese_brazil
import nuplist.composeapp.generated.resources.system
import nuplist.composeapp.generated.resources.theme
import org.jetbrains.compose.resources.StringResource

sealed class SelectableOption(
    val name: StringResource,
    val icon: ImageVector?,
    val key: String,
    val menuIcon: ImageVector,
    val menuName: StringResource,
) {

    abstract fun getDefault(): SelectableOption

    sealed class Theme(
        name: StringResource,
        icon: ImageVector,
    ) : SelectableOption(
        name = name,
        icon = icon,
        key = PreferencesKeys.THEME,
        menuIcon = Icons.Filled.Brush,
        menuName = Res.string.theme,
    ) {
        override fun getDefault(): SelectableOption = System

        data object System : Theme(
            name = Res.string.system,
            icon = Icons.Filled.Brightness6
        )

        data object Light : Theme(
            name = Res.string.light,
            icon = Icons.Filled.LightMode
        )

        data object Dark : Theme(
            name = Res.string.dark,
            icon = Icons.Filled.DarkMode
        )
    }

    sealed class Language(name: StringResource) : SelectableOption(
        name = name,
        icon = null,
        key = PreferencesKeys.LANGUAGE,
        menuIcon = Icons.Filled.Language,
        menuName = Res.string.language,
    ) {
        override fun getDefault(): SelectableOption = System

        data object System: Language(name = Res.string.system)

        data object PortugueseBrazil : Language(name = Res.string.portuguese_brazil)

        data object EnglishUnitedStates : Language(name = Res.string.english)
    }
}
