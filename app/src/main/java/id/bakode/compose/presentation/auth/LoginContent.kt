@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class
)

package id.bakode.compose.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.bakode.compose.ui.component.ExpComposeButton
import id.bakode.compose.ui.component.ExpComposeForm
import id.bakode.compose.ui.component.annotatedText
import id.bakode.compose.ui.theme.Typography
import id.bakode.compose.ui.theme.getDrawableLogo
import id.bakode.compose.ui.theme.getThemeColor
import id.bakode.compose.util.enums.AuthPageState

@Composable
fun SignInContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(bottom = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = getDrawableLogo()),
                contentDescription = "BAKODE_LOGO",
                modifier = Modifier
                    .requiredSize(55.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = "Sign In \uD83E\uDDD0",
                    style = Typography.titleLarge,
                    color = getThemeColor(),
                )
                Text(
                    text = "Karlota Messenger",
                    style = Typography.labelMedium,
                    color = getThemeColor()
                )
            }
        }

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
            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = annotatedText(
                        clickableText = "Forgot password?",
                    ),
                    onClick = {
                        navController.navigate(AuthPageState.FORGOT_PASSWORD.name) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            
            ExpComposeButton(text = "Sign In", action = {
                println("LEME LOGIN")
            })

            Spacer(modifier = Modifier.height(32.dp))

            val annotatedText = annotatedText(
                mainText =  "Don't have an account? ",
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
                    ).firstOrNull()?.let {
                        navController.navigate(AuthPageState.REGISTER.name) {
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

