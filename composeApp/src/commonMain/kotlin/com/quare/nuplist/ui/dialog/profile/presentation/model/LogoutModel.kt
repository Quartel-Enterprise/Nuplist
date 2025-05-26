package com.quare.nuplist.ui.dialog.profile.presentation.model

data class LogoutModel(
    val onClick: () -> Unit,
    val isLoading: Boolean,
)
