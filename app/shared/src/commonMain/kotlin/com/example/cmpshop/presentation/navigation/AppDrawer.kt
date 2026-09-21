package com.example.cmpshop.presentation.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    currentRoute: AppRoutes?,
    destination: List<DrawerDestination>,
    onDestinationClick:(DrawerDestination)-> Unit,
    content: @Composable (onMenuClick: () -> Unit) -> Unit
) {
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()
    fun openDrawer() {
        scope.launch {
            drawerState.open()
        }
    }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerContent(
                currentRoute = currentRoute,
                destination = destination,
                onItemClick = { destination ->
                    onDestinationClick(destination)
                    scope.launch {
                        drawerState.close()
                    }
                }

            )
        }
    ){
        content(
            ::openDrawer
        )
    }

}

