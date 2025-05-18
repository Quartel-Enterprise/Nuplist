package com.quare.nuplist.feature.login.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class SessionUserMetadataModel(
    @SerialName("avatar_url") val photo: String?,
    @SerialName("name") val name: String,
)
