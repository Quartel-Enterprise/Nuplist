package com.quare.nuplist.app.domain

import com.quare.nuplist.core.theme.ThemeOption

class GetThemeOptionUseCase {
    suspend operator fun invoke(): ThemeOption = ThemeOption.SYSTEM
}
