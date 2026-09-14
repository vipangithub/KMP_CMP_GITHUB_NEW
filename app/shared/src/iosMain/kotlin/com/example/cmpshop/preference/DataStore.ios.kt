package com.example.cmpshop.preference

import androidx.datastore.core.DataStore
import androidx.datastore.core.okio.OkioStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer
import com.example.cmpshop.createDataStore
import com.example.cmpshop.data.preferences.DATA_STORE_FILE_NAME
import kotlinx.cinterop.ExperimentalForeignApi
import okio.FileSystem
import okio.Path.Companion.toPath
import platform.Foundation.NSFileManager
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
fun createDataStore(): DataStore<Preferences> {
    return createDataStore(
        storage = OkioStorage(
            fileSystem = FileSystem.SYSTEM,
            serializer = PreferencesSerializer,
            producePath = {
                val documentDirectory =
                    NSFileManager.defaultManager.URLForDirectory(
                        directory = NSDocumentDirectory,
                        inDomain = NSUserDomainMask,
                        appropriateForURL = null,
                        create = false,
                        error = null
                    )

                (
                        requireNotNull(documentDirectory).path
                                + "/$DATA_STORE_FILE_NAME"
                        ).toPath()
            }
        )
    )
}