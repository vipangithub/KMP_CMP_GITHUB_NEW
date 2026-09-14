package com.example.cmpshop.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductPromoCardScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp)
    ) {

        Text(
            text = "Background & Colors",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Simple background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Primary Container",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Surface
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceContainer,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Material Surface",
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Product Card",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Card with Material color"
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Border
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    2.dp,
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text("Border Example")
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    ),
                    RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Gradient Background",
                color = Color.White
            )
        }
    }
}