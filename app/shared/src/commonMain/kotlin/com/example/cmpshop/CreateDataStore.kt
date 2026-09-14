package com.example.cmpshop

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences

internal const val DATA_STORE_FILE_NAME = "app_preferences.preferences_pb"

internal fun createDataStore(
    storage: Storage<Preferences>
): DataStore<Preferences> {
    return DataStoreFactory.create(storage = storage)
}

//expect fun createDataStore(): DataStore<Preferences>