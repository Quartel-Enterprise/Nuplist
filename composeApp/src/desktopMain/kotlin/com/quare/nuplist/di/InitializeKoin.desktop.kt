package com.quare.nuplist.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.quare.nuplist.core.config.DATA_STORE_FILE_NAME
import com.quare.nuplist.core.config.createDataStore
import com.quare.nuplist.core.internationalization.domain.Localization
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { Localization() }
    single<DataStore<Preferences>> { createDataStore { DATA_STORE_FILE_NAME } }
}
