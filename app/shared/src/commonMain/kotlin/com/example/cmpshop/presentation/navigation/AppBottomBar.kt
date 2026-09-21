package com.example.cmpshop.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar(
    currentDestination: AppRoutes?,
    onDestinationClick: (AppDestination) -> Unit
) {
    NavigationBar {

        appDestinations.forEach { destination ->

            NavigationBarItem(
                selected = currentDestination == destination.route,

                onClick = {
                    onDestinationClick(destination)
                },

                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.title
                    )
                },

                label = {
                    Text(destination.title)
                }
            )
        }
    }
}