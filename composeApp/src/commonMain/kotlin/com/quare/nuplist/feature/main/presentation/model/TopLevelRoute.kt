package com.quare.nuplist.feature.main.presentation.model

data class TopLevelRoute<T: Any>(
    val presentationModel: BottomNavigationItemPresentationModel,
    val route: T,
)
