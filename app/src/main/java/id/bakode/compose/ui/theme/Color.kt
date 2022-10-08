package id.bakode.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val GREEN300 = Color(0xFF7eb0ad)
val GREEN500 = Color(0xFF19887a)
val GREEN700 = Color(0xFF00574B)

val DARK_GREEN200 = Color(0xFF232D36)
val DARK_GREEN300 = Color(0xFF101D25)
val DARK = Color(0xFF000000)

val WHITE200 = Color(0xFFe0e0e0)
val BLACK200 = Color(0xFA212020)
val GRAY100 = Color(0xC1EFF0F3)
val GRAY200 = Color(0xFF88898b)

@Composable
fun getTabPrimaryColor(): Color {
    return if (isSystemInDarkTheme()) {
        BLACK200
    } else {
        WHITE200
    }
}

@Composable
fun getTitleColor(): Color {
    return if (isSystemInDarkTheme()) {
        WHITE200
    } else {
        BLACK200
    }
}