@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)

package id.bakode.compose.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import id.bakode.compose.ui.component.ExpComposeButton
import id.bakode.compose.ui.component.ExpComposeForm

@Composable
fun ForgotPasswordContent() {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        ExpComposeForm(
            label = "Email",
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        ExpComposeButton(text = "Forgot Password", action = {
            println("LEME RESET PASSWORD")
        })
    }
}
