package com.quare.nuplist.core.config

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

fun createDataStore(context: Context): DataStore<Preferences> = createDataStore {
    context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
}
