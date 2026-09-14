package com.example.cmpshop.preference

import com.example.cmpshop.createDataStore
import com.example.cmpshop.data.preferences.DATA_STORE_FILE_NAME

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.okio.OkioStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer
import okio.FileSystem
import okio.Path.Companion.toPath
 fun createDataStore(
    context: Context
): DataStore<Preferences> =
    createDataStore(
        storage = OkioStorage(
            fileSystem = FileSystem.SYSTEM,
            serializer = PreferencesSerializer,
            producePath = {
                context.filesDir
                    .resolve(DATA_STORE_FILE_NAME)
                    .absolutePath
                    .toPath()
            }
        )
    )