package com.example.cmpshop

import androidx.compose.ui.window.ComposeUIViewController
import com.example.cmpshop.data.local_db.AppDatabase
import com.example.cmpshop.data.local_db.DatabaseDriverFactory
import com.example.cmpshop.preference.createDataStore
import platform.UIKit.UIViewController

//fun MainViewController() = ComposeUIViewController {
////    App()
//    val dataStore = createDataStore()
//
//    App(
//        dataStore = dataStore
//    )
//}

fun MainViewController(): UIViewController =
    ComposeUIViewController {
        val dataStore = createDataStore()
        val database = AppDatabase(
            driver = DatabaseDriverFactory().createDriver()
        )
        App(
            dataStore = dataStore,
            database = database
        )
    }

