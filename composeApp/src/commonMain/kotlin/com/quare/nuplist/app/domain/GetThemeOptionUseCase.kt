package com.quare.nuplist.app.domain

import com.quare.nuplist.core.option.SelectableOption

class GetThemeOptionUseCase {
    suspend operator fun invoke(): SelectableOption.Theme = SelectableOption.Theme.System
}
