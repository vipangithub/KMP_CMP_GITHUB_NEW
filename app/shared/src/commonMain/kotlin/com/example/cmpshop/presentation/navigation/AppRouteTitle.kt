package com.example.cmpshop.presentation.navigation

fun getDestinationTitle(route: AppRoutes?): String {
    return when (route) {
        AppRoutes.Home -> "Home"
        AppRoutes.Products -> "Products"
        AppRoutes.PostCompose -> "Posts"
        AppRoutes.SettingScreen -> "Settings"
        is AppRoutes.ProductDetail -> "Product Details"
        else -> "CMP Shop"
    }
}