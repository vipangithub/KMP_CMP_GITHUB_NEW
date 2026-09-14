package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp

enum class WindowWidthSizeClass{
    Compact,
    Medium,
    Expanded
}

@Composable
fun rememberWindowWidthSizeClass(): WindowWidthSizeClass{
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current

    val widthDp = with(density){
        windowInfo.containerSize.width.toDp()
    }
    return when{
        widthDp < 600.dp -> WindowWidthSizeClass.Compact
        widthDp < 840.dp -> WindowWidthSizeClass.Medium
        else -> WindowWidthSizeClass.Expanded
    }
}