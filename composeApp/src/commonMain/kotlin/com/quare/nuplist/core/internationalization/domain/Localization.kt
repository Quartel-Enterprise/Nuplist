package com.quare.nuplist.core.internationalization.domain

import com.quare.nuplist.core.option.SelectableOption

expect class Localization {
    fun applyLanguage(language: SelectableOption.Language)
}
