package com.example.cmpshop.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

val drawerDestinations = listOf(
    DrawerDestination(
        title = "Home",
        route = AppRoutes.Home,
        icon = Icons.Default.Home
    ),
    DrawerDestination(
        title = "Products",
        route = AppRoutes.Products,
        icon = Icons.Default.ShoppingCart
    ),
    DrawerDestination(
        title = "Posts",
        route = AppRoutes.PostCompose,
        icon = Icons.Default.List
    ),
    DrawerDestination(
        title = "Settings",
        route = AppRoutes.SettingScreen,
        icon = Icons.Default.Settings
    )

    )

data class DrawerDestination(
    val title: String,
    val route: AppRoutes,
    val icon: ImageVector
)