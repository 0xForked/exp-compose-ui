package id.bakode.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val GREEN300 = Color(0xFF7eb0ad)
val GREEN500 = Color(0xFF19887a)

val DARK_GREEN200 = Color(0xFF232D36)
val DARK_GREEN300 = Color(0xFF101D25)

val WHITE200 = Color(0xFFe0e0e0)
val BLACK200 = Color(0xFA212020)
val GRAY200 = Color(0xFF88898b)

@Composable
fun getThemeColor(): Color {
    return if (isSystemInDarkTheme()) {
        WHITE200
    } else {
        BLACK200
    }
}

@Composable
fun getTextButtonColor(): Color {
    return if (isSystemInDarkTheme()) {
        BLACK200
    } else {
        WHITE200
    }
}