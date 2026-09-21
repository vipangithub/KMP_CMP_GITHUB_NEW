package com.example.cmpshop.presentation.navigation

import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawerContent(
    currentRoute: AppRoutes?,
     destination: List<DrawerDestination>,
    onItemClick:(DrawerDestination) -> Unit
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "CMP Shop",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    horizontal = 24.dp, vertical = 16.dp
                )
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            destination.forEach {destination->
                NavigationDrawerItem(
                    label = {
                        Text(destination.title)
                    },
                    selected = currentRoute == destination.route,
                    onClick = {
                        onItemClick(destination)
                    },
                    icon ={
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.padding(
                        horizontal = 12.dp
                    )
                )

            }
        }
    }

}




