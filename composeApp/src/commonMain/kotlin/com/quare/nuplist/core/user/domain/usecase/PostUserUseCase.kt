package com.quare.nuplist.core.user.domain.usecase

import com.quare.nuplist.core.user.domain.model.UserModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class PostUserUseCase(
    private val supabaseClient: SupabaseClient,
) {

    suspend operator fun invoke(userModel: UserModel) {
        getExistingUserId(userModel.id) ?: insertUser(userModel)
    }

    private suspend fun getExistingUserId(
        userId: String,
    ): String? = getUserIds().find { id ->
        userId == id
    }

    private suspend fun getUserIds(): List<String> = supabaseClient.from(TABLE_USERS).select(
        Columns.raw(COLUMN_ID)
    ).decodeList<String>()

    private suspend fun insertUser(userModel: UserModel) {
        supabaseClient.from(TABLE_USERS).insert(userModel.toRow())
    }

    private fun UserModel.toRow(): Map<String, String?> = mapOf(
        COLUMN_ID to id,
        COLUMN_NAME to name,
        COLUMN_EMAIL to email,
        COLUMN_PHOTO_URL to photo,
    )

    companion object {
        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PHOTO_URL = "photo_url"
    }
}
