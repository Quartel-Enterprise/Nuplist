package com.quare.nuplist.core.user.domain.usecase

import com.quare.nuplist.core.user.data.UserEmail
import com.quare.nuplist.core.user.domain.model.UserModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class PostUserUseCase(
    private val supabaseClient: SupabaseClient,
) {

    suspend operator fun invoke(userModel: UserModel) {
        getExistingUser(userModel.email) ?: insertUser(userModel)
    }

    private suspend fun getExistingUser(
        userEmail: String,
    ): String? = getUserEmailColumn().find {
        userEmail == it.data
    }?.data

    private suspend fun getUserEmailColumn(): List<UserEmail> = supabaseClient.from(TABLE_USERS).select(
        Columns.raw(COLUMN_EMAIL)
    ).decodeList<UserEmail>()

    private suspend fun insertUser(userModel: UserModel) {
        supabaseClient.from(TABLE_USERS).insert(userModel.toRow())
    }

    private fun UserModel.toRow(): Map<String, String?> = mapOf(
        COLUMN_NAME to name,
        COLUMN_EMAIL to email,
        COLUMN_PHOTO_URL to photo,
    )

    companion object {
        private const val TABLE_USERS = "users"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PHOTO_URL = "photo_url"
    }
}
