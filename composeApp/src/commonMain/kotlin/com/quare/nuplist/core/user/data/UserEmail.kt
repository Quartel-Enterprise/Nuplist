package com.quare.nuplist.core.user.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserEmail(
    @SerialName("email") val data: String,
)
