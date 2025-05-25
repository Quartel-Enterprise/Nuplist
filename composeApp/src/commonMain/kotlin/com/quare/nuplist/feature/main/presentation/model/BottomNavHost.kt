package com.quare.nuplist.feature.main.presentation.model

data class BottomNavHost<T: Any>(
    val presentationModel: BottomNavigationItemPresentationModel,
    val route: T,
)
