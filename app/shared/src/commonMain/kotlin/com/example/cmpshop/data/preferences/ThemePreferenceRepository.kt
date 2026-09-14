package com.example.cmpshop.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.cmpshop.theme.ThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val DATA_STORE_FILE_NAME = "prefs.preferences_pb"

class ThemePreferenceRepository(private val dataStore: DataStore<Preferences>) {
    private val themeModeKey = stringPreferencesKey("theme_mode")

    val themeMode: Flow<ThemeMode> = dataStore.data.map { preferences ->
        val name = preferences[themeModeKey] ?: ThemeMode.SYSTEM.name
        ThemeMode.valueOf(name)
    }

    suspend fun saveThemeMode(mode: ThemeMode) {
        dataStore.edit { preferences ->
            preferences[themeModeKey] = mode.name
        }
    }
}
