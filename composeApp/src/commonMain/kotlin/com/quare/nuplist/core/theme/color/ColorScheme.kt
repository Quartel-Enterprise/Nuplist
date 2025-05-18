package com.quare.nuplist.core.theme.color


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.quare.nuplist.core.theme.color.palette.backgroundDark
import com.quare.nuplist.core.theme.color.palette.backgroundLight
import com.quare.nuplist.core.theme.color.palette.errorContainerDark
import com.quare.nuplist.core.theme.color.palette.errorContainerLight
import com.quare.nuplist.core.theme.color.palette.errorDark
import com.quare.nuplist.core.theme.color.palette.errorLight
import com.quare.nuplist.core.theme.color.palette.inverseOnSurfaceDark
import com.quare.nuplist.core.theme.color.palette.inverseOnSurfaceLight
import com.quare.nuplist.core.theme.color.palette.inversePrimaryDark
import com.quare.nuplist.core.theme.color.palette.inversePrimaryLight
import com.quare.nuplist.core.theme.color.palette.inverseSurfaceDark
import com.quare.nuplist.core.theme.color.palette.inverseSurfaceLight
import com.quare.nuplist.core.theme.color.palette.onBackgroundDark
import com.quare.nuplist.core.theme.color.palette.onBackgroundLight
import com.quare.nuplist.core.theme.color.palette.onErrorContainerDark
import com.quare.nuplist.core.theme.color.palette.onErrorContainerLight
import com.quare.nuplist.core.theme.color.palette.onErrorDark
import com.quare.nuplist.core.theme.color.palette.onErrorLight
import com.quare.nuplist.core.theme.color.palette.onPrimaryContainerDark
import com.quare.nuplist.core.theme.color.palette.onPrimaryContainerLight
import com.quare.nuplist.core.theme.color.palette.onPrimaryDark
import com.quare.nuplist.core.theme.color.palette.onPrimaryLight
import com.quare.nuplist.core.theme.color.palette.onSecondaryContainerDark
import com.quare.nuplist.core.theme.color.palette.onSecondaryContainerLight
import com.quare.nuplist.core.theme.color.palette.onSecondaryDark
import com.quare.nuplist.core.theme.color.palette.onSecondaryLight
import com.quare.nuplist.core.theme.color.palette.onSurfaceDark
import com.quare.nuplist.core.theme.color.palette.onSurfaceLight
import com.quare.nuplist.core.theme.color.palette.onSurfaceVariantDark
import com.quare.nuplist.core.theme.color.palette.onSurfaceVariantLight
import com.quare.nuplist.core.theme.color.palette.onTertiaryContainerDark
import com.quare.nuplist.core.theme.color.palette.onTertiaryContainerLight
import com.quare.nuplist.core.theme.color.palette.onTertiaryDark
import com.quare.nuplist.core.theme.color.palette.onTertiaryLight
import com.quare.nuplist.core.theme.color.palette.outlineDark
import com.quare.nuplist.core.theme.color.palette.outlineLight
import com.quare.nuplist.core.theme.color.palette.outlineVariantDark
import com.quare.nuplist.core.theme.color.palette.outlineVariantLight
import com.quare.nuplist.core.theme.color.palette.primaryContainerDark
import com.quare.nuplist.core.theme.color.palette.primaryContainerLight
import com.quare.nuplist.core.theme.color.palette.primaryDark
import com.quare.nuplist.core.theme.color.palette.primaryLight
import com.quare.nuplist.core.theme.color.palette.scrimDark
import com.quare.nuplist.core.theme.color.palette.scrimLight
import com.quare.nuplist.core.theme.color.palette.secondaryContainerDark
import com.quare.nuplist.core.theme.color.palette.secondaryContainerLight
import com.quare.nuplist.core.theme.color.palette.secondaryDark
import com.quare.nuplist.core.theme.color.palette.secondaryLight
import com.quare.nuplist.core.theme.color.palette.surfaceBrightDark
import com.quare.nuplist.core.theme.color.palette.surfaceBrightLight
import com.quare.nuplist.core.theme.color.palette.surfaceContainerDark
import com.quare.nuplist.core.theme.color.palette.surfaceContainerHighDark
import com.quare.nuplist.core.theme.color.palette.surfaceContainerHighLight
import com.quare.nuplist.core.theme.color.palette.surfaceContainerHighestDark
import com.quare.nuplist.core.theme.color.palette.surfaceContainerHighestLight
import com.quare.nuplist.core.theme.color.palette.surfaceContainerLight
import com.quare.nuplist.core.theme.color.palette.surfaceContainerLowDark
import com.quare.nuplist.core.theme.color.palette.surfaceContainerLowLight
import com.quare.nuplist.core.theme.color.palette.surfaceContainerLowestDark
import com.quare.nuplist.core.theme.color.palette.surfaceContainerLowestLight
import com.quare.nuplist.core.theme.color.palette.surfaceDark
import com.quare.nuplist.core.theme.color.palette.surfaceDimDark
import com.quare.nuplist.core.theme.color.palette.surfaceDimLight
import com.quare.nuplist.core.theme.color.palette.surfaceLight
import com.quare.nuplist.core.theme.color.palette.surfaceVariantDark
import com.quare.nuplist.core.theme.color.palette.surfaceVariantLight
import com.quare.nuplist.core.theme.color.palette.tertiaryContainerDark
import com.quare.nuplist.core.theme.color.palette.tertiaryContainerLight
import com.quare.nuplist.core.theme.color.palette.tertiaryDark
import com.quare.nuplist.core.theme.color.palette.tertiaryLight

internal val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

internal val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)
