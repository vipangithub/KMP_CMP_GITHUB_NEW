package com.example.cmpshop.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposeBasicsScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp).windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Text(
            text = "Compose Basic",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(20.dp))
        // Column
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Column")
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Text("First Item")
                Text("Second Item")
                Text("Column")

            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        // Row
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Row")
                Text("Horizontal Layout")

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Box
        Card(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.fillMaxWidth().height(120.dp)
            ) {
                Box(
                    modifier = Modifier.size(120.dp).background(
                        MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "Box",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
// Weight
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(
                text = "Product",
                modifier = Modifier.weight(1f).background(
                    MaterialTheme.colorScheme.primaryContainer
                ).padding(16.dp)
            )
            Text(
                text = "Fixed",
                modifier = Modifier.background(
                    MaterialTheme.colorScheme.secondaryContainer
                ).padding(16.dp)
            )

        }

        Button(
            onClick ={

            }
        ){
            Text("Text Button")
        }

    }
}