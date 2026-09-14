package com.example.cmpshop.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.fitness_app_icon
import io.ktor.http.ContentDisposition
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.fitness_app_icon),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = "ShowFlow",
            style = MaterialTheme.typography.headlineMedium
        )

    }
}