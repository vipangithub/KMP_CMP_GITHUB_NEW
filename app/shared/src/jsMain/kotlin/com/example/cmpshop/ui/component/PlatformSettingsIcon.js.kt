package com.example.cmpshop.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
actual fun PlatformSettingsIcon() {
    Icon(
        imageVector = Icons.Default.Settings,
        contentDescription = "Settings"
    )
}
