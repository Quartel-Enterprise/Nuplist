package com.quare.nuplist.ui.dialog.profile.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class LogoutModel(
    val onClick: () -> Unit,
    val isLoading: Boolean,
)
