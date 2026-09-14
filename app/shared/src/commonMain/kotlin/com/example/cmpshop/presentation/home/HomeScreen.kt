package com.example.cmpshop.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cmpshop.ui.component.PlatformSettingsIcon

@Composable
fun HomeScreen(
    onViewProductClick: () -> Unit,
    settingClick:()-> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shop Flow", style = MaterialTheme.typography.bodyLarge) },
                actions = {
                    IconButton(onClick = settingClick){
                        PlatformSettingsIcon()
                    }

                }
            )
        }
    ) { innerpadding ->

    Column(
        modifier = Modifier.fillMaxSize().padding(innerpadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = "ShowFlow",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        Text(
            text = "Welcome to ShowFlow",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        Button(
            onClick = onViewProductClick
        ) {
            Text("View Product")
        }

    }
}
}