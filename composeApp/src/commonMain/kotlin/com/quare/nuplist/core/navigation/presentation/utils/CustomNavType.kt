package com.quare.nuplist.core.navigation.presentation.utils

import androidx.navigation.NavType
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import io.ktor.http.decodeURLPart
import io.ktor.http.encodeURLParameter
import kotlinx.serialization.json.Json

inline fun <reified T : Any?> serializableType(
    json: Json = Json,
): NavType<T> = object : NavType<T>(isNullableAllowed = null is T) {
    override fun get(bundle: SavedState, key: String): T? =
        bundle.read {
            getString(key).let {
                json.decodeFromString<T>(it.decodeURLPart())
            }
        }

    // Navigation takes care of decoding the string
    // before passing it to parseValue()
    override fun parseValue(value: String): T = json.decodeFromString(value)

    // Serialized values must always be Uri encoded
    override fun serializeAsValue(value: T): String =
        json.encodeToString(value).encodeURLParameter()

    override fun put(bundle: SavedState, key: String, value: T) {
        bundle.write {
            putString(key, serializeAsValue(value))
        }
    }
}
