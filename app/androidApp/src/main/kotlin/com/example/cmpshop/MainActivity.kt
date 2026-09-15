package com.example.cmpshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cmpshop.data.local_db.AppDatabase
import com.example.cmpshop.data.local_db.DatabaseDriverFactory
import com.example.cmpshop.preference.createDataStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val dataStore = createDataStore(applicationContext)
        val database = AppDatabase(
            driver = DatabaseDriverFactory(
                applicationContext
            ).createDriver()
        )
        setContent {
            App(dataStore = dataStore,database= database)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
  //  App()
}