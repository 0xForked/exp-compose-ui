package id.bakode.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import id.bakode.compose.R

@Composable
fun getDrawableLogo(): Int {
    return if (isSystemInDarkTheme()) {
        R.drawable.bakode_white
    } else {
        R.drawable.bakode_black
    }
}