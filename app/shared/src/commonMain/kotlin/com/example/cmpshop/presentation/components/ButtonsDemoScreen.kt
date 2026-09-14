package com.example.cmpshop.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ButtonsDemoScreen() {

    var isFavorite by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false)}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buttons Types") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp)
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                "Button",
                style = MaterialTheme.typography.headlineSmall
            )
            // filled Button
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Filled Button")
            }
            // Filled tonal

            FilledTonalButton(
                onClick = {},
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Filled tonal")
            }
            //  // 3. Elevated
            ElevatedButton(
                onClick = {}
            ) {
                Text(
                    "Elevated"
                )
            }
            //Outlined
            OutlinedButton(
                onClick = {}
            ) {
                Text("Outlined")
            }
            //Text Button

            TextButton(
                onClick = {}
            ) {
                Text("Text Button")
            }
            // Button with Icon
            Button(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = ""
                )
                Spacer(
                    modifier = Modifier.width(8.dp)
                )
                Text("Add to cart")

            }

            // Disabled
            Button(
                onClick = {},
                enabled = false
            ) {
                Text("Disabled")
            }
            // Full width

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Full width")
            }

            //  Icon Toggle button
            IconToggleButton(
                checked = isFavorite,
                onCheckedChange = {
                    isFavorite = it
                }
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = ""
                )

            }

            // Floating action

            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = ""
                )
            }

            // Small Floating
            SmallFloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }

            //Large Fab
            LargeFloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
            // Extended FAB
            ExtendedFloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text("Create")
            }

            // Loading Button

            Button(
                onClick = {
                    isLoading = true
                },
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Submit")
                }
            }
        }
    }
}