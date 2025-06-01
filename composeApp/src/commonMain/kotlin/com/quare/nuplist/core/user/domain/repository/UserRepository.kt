package com.quare.nuplist.core.user.domain.repository

import com.quare.nuplist.core.user.domain.model.UserModel

interface UserRepository {
    suspend fun getUser(): UserModel?
    suspend fun postUser(): Result<Unit>
}
