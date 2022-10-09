package id.bakode.compose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    primaryContainer = Color.LightGray,
    secondary = GREEN500,
    background = DARK_GREEN300,
    tertiary = WHITE200,
    onTertiary = GRAY200
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Black,
    primaryContainer = Color.DarkGray,
    secondary = GREEN300,
    background = WHITE200,
    tertiary = WHITE200,
    onTertiary = GRAY200
)

private val LightBackgroundTheme = BackgroundTheme(color = Color.White)

private val DarkBackgroundTheme = BackgroundTheme(color = Color.Black)

@Composable
fun ExpComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val backgroundTheme = if (darkTheme) DarkBackgroundTheme else LightBackgroundTheme

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}