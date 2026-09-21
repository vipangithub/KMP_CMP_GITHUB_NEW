package com.example.cmpshop.presentation.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute

//fun getCurrentDestination(
//    backStackEntry: NavBackStackEntry?
//): AppRoutes? {
//
//    if (backStackEntry == null) {
//        return null
//    }
//
//    return when {
//        backStackEntry.destination.hasRoute<AppRoutes.Home>() -> {
//            AppRoutes.Home
//        }
//
//        backStackEntry.destination.hasRoute<AppRoutes.Products>() -> {
//            AppRoutes.Products
//        }
//
//        backStackEntry.destination.hasRoute<AppRoutes.ProductDetail>() -> {
//            backStackEntry.toRoute<AppRoutes.ProductDetail>()
//        }
//
//        backStackEntry.destination.hasRoute<AppRoutes.SettingScreen>() -> {
//            AppRoutes.SettingScreen
//        }
//
//        backStackEntry.destination.hasRoute<AppRoutes.PostCompose>() -> {
//            AppRoutes.PostCompose
//        }
//
//        else -> null
//    }
//}

fun getCurrentDestination(
    backStackEntry: NavBackStackEntry?
): AppRoutes? {

    val destination = backStackEntry?.destination
        ?: return null

    return when {
        destination.hasRoute<AppRoutes.Home>() ->
            AppRoutes.Home

        destination.hasRoute<AppRoutes.Products>() ->
            AppRoutes.Products

        destination.hasRoute<AppRoutes.ProductDetail>() ->
            backStackEntry.toRoute<AppRoutes.ProductDetail>()

        destination.hasRoute<AppRoutes.SettingScreen>() ->
            AppRoutes.SettingScreen

        destination.hasRoute<AppRoutes.PostCompose>() ->
            AppRoutes.PostCompose

        else -> null
    }
}