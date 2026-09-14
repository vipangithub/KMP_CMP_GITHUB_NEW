package com.example.cmpshop.ui.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.settings_icon_android
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun PlatformSettingsIcon() {
    Icon(
        painter = painterResource(Res.drawable.settings_icon_android),
        contentDescription = "Settings"
    )
}
