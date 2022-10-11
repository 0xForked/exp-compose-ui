package id.bakode.compose.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import id.bakode.compose.ui.theme.GREEN500
import id.bakode.compose.ui.theme.getThemeColor

@Composable
fun annotatedText(
    mainText: String = "",
    clickableText: String = "",
    tag: String = ""
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = getThemeColor(),
        )) { append(mainText) }

        pushStringAnnotation(tag = tag, annotation = tag)

        withStyle(style = SpanStyle(
            fontWeight = FontWeight.Bold,
            color = GREEN500,
            textDecoration = TextDecoration.Underline,
        )) { append(clickableText) }
    }
}
