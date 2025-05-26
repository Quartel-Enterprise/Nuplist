package com.quare.nuplist.app.domain

import com.quare.nuplist.core.option.SelectableOption

class GetLanguageOptionUseCase {
    suspend operator fun invoke(): SelectableOption.Language = SelectableOption.Language.English
}
