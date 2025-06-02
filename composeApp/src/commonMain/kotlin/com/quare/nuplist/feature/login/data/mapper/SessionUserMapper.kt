package com.quare.nuplist.feature.login.data.mapper

import com.quare.nuplist.core.user.domain.model.UserModel
import com.quare.nuplist.feature.login.data.dto.SessionUserMetadataModel
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.serialization.json.Json

class SessionUserMapper {

    private val jsonSerializer = Json {
        ignoreUnknownKeys = true
    }

    fun map(sessionUser: UserInfo): UserModel? = sessionUser.userMetadata?.let {
        val sessionUserMetadataDto = jsonSerializer
            .decodeFromString<SessionUserMetadataModel>(it.toString())
        UserModel(
            photo = sessionUserMetadataDto.photo ?: return@let null,
            name = sessionUserMetadataDto.name,
            id = sessionUser.id,
            email = sessionUser.email ?: return@let null,
        )
    }
}
