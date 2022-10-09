package id.bakode.compose.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.bakode.compose.ui.component.ExpComposeButton
import id.bakode.compose.ui.component.ExpComposeForm
import id.bakode.compose.ui.component.annotatedText

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SignInContent() {
    Column(
        modifier = Modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExpComposeForm(
            label = "Email",
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        ExpComposeForm(
            label = "Password",
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password,
            modifier = Modifier.padding(bottom = 16.dp),
            passwordField = true
        )
        ExpComposeButton(text = "Sign In", action = {
            println("LEME LOGIN")
        })
        
        Spacer(modifier = Modifier.height(32.dp))

        val annotatedText = annotatedText(
            mainText = "Don't have an account? ",
            clickableText = "Sign Up",
            tag = "SignUp"
        )

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "SignUp",
                    start = offset,
                    end = offset
                )[0].let { annotation ->
                    println("click ${annotation.item}")
                }
            }
        )
    }
}

