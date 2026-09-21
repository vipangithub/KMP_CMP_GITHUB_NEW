package com.example.cmpshop.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart

val appDestinations = listOf(
    AppDestination(
        title = "Home",
        route = AppRoutes.Home,
        icon = Icons.Default.Home
    ),
    AppDestination(
        title = "Products",
        route = AppRoutes.Products,
        icon = Icons.Default.ShoppingCart
    ),
    AppDestination(
        title = "Posts",
        route = AppRoutes.PostCompose,
        icon = Icons.Default.List
    ),
    AppDestination(
        title = "Settings",
        route = AppRoutes.SettingScreen,
        icon = Icons.Default.Settings
    )
)
data class AppDestination(
    val title: String,
    val route: AppRoutes,
    val icon: ImageVector)