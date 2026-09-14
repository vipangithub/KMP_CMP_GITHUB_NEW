package com.example.cmpshop.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.poppins_regular
import cmpshop.app.shared.generated.resources.poppins_bold
import cmpshop.app.shared.generated.resources.poppins_medium
import cmpshop.app.shared.generated.resources.poppins_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun poppinsFontFamily() = FontFamily(
    Font(Res.font.poppins_regular, FontWeight.Normal),
    Font(Res.font.poppins_medium, FontWeight.Medium),
    Font(Res.font.poppins_semibold, FontWeight.SemiBold),
    Font(Res.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun appTypography(): Typography {
    val fontFamily = poppinsFontFamily()
    return Typography(
        displayLarge = Typography().displayLarge.copy(fontFamily = fontFamily),
        displayMedium = Typography().displayMedium.copy(fontFamily = fontFamily),
        displaySmall = Typography().displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = Typography().headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = Typography().headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = Typography().headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = Typography().titleLarge.copy(fontFamily = fontFamily),
        titleMedium = Typography().titleMedium.copy(fontFamily = fontFamily),
        titleSmall = Typography().titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = Typography().bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = Typography().bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = Typography().bodySmall.copy(fontFamily = fontFamily),
        labelLarge = Typography().labelLarge.copy(fontFamily = fontFamily),
        labelMedium = Typography().labelMedium.copy(fontFamily = fontFamily),
        labelSmall = Typography().labelSmall.copy(fontFamily = fontFamily)
    )
}
