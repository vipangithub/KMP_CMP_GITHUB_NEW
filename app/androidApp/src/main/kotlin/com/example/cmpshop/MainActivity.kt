package com.example.cmpshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cmpshop.preference.createDataStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val dataStore = createDataStore(applicationContext)
        setContent {
            App(dataStore = dataStore)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
  //  App()
}