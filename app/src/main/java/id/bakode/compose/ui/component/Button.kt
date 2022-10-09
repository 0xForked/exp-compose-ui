package id.bakode.compose.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.bakode.compose.ui.theme.*

@Composable
fun ExpComposeButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    action: () -> Unit
) {
   Button(
       onClick = action,
       modifier = modifier
           .fillMaxWidth()
           .height(50.dp),
       shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text,
            color = getTextButtonColor(),
            style = Typography.titleMedium
        )
    }
}

@Composable
fun ExpComposeTexButton(
    modifier: Modifier = Modifier,
) {
    TextButton(onClick = { /* Do something! */ }) {
        Text("I'm a Text Button")
    }
}