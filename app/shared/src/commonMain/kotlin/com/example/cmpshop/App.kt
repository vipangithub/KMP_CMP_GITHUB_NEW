package com.example.cmpshop

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cmpshop.data.local_db.AppDatabase
import com.example.cmpshop.data.local_db.DatabaseDriverFactory
import com.example.cmpshop.di.AppContainer
import com.example.cmpshop.presentation.SplashScreen

import com.example.cmpshop.presentation.navigation.AppNavigation
import com.example.cmpshop.theme.AppTheme
import com.example.cmpshop.theme.ThemeMode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App(
    dataStore: DataStore<Preferences>,
    database: AppDatabase,
    ) {
    var showSplash by remember {
        mutableStateOf(true)
    }
//    var themeMode by remember {
//        mutableStateOf(ThemeMode.SYSTEM)
//    }
    val appContainer = remember {
        AppContainer(
            dataStore = dataStore,
            database = database
        )
    }

    val themeRepo = appContainer.themePreferenceRepository


    val saveThemeMode by themeRepo.themeMode.collectAsStateWithLifecycle(
        initialValue = ThemeMode.SYSTEM
    )

    val scope = rememberCoroutineScope()

    val darkTheme = when (saveThemeMode) {
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    LaunchedEffect(Unit) {
        delay(1500)
        showSplash = false
    }
    AppTheme(
        darkTheme = darkTheme
    ) {
        if (showSplash) SplashScreen()
        else AppNavigation(
            appContainer = appContainer,
            themeMode = saveThemeMode,
            onThemeModeChange = { newMode ->
                scope.launch {
                    themeRepo.saveThemeMode(newMode)
                }
            }
        )
    }
}
