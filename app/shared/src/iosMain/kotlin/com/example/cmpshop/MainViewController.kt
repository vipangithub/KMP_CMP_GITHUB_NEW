package com.example.cmpshop

import androidx.compose.ui.window.ComposeUIViewController
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

        App(
            dataStore = dataStore
        )
    }

