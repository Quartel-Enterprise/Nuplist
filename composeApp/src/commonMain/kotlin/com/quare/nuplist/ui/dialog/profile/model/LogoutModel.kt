package com.quare.nuplist.ui.dialog.profile.model

data class LogoutModel(
    val onClick: () -> Unit,
    val isLoading: Boolean,
)
