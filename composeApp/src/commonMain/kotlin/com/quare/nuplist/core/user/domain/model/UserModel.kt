package com.quare.nuplist.core.user.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val id: String,
    val name: String,
    val photo: String?,
    val email: String?,
)
