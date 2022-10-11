package id.bakode.compose.presentation.auth

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.bakode.compose.ui.component.ExpComposeBackground
import id.bakode.compose.ui.theme.ExpComposeTheme
import id.bakode.compose.util.enums.AuthPageState

var authPageState: AuthPageState = AuthPageState.LOGIN

class AuthenticationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { AuthenticationContent() }
    }
}

@Preview(
    name = "Normal",
    group = "Screen",
    showBackground = true
)
@Preview(
    name = "Dark",
    group = "Screen",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AuthenticationContent() {
    val navController = rememberNavController()

    ExpComposeTheme {
        ExpComposeBackground {
            NavHost(
                navController = navController,
                startDestination = AuthPageState.LOGIN.name,
                builder = {
                    composable(
                        AuthPageState.LOGIN.name,
                        content = {
                            SignInContent(navController = navController)
                            authPageState = AuthPageState.LOGIN
                        }
                    )
                    composable(
                        AuthPageState.REGISTER.name,
                        content = {
                            SignUpContent(navController = navController)
                            authPageState = AuthPageState.REGISTER
                        }
                    )
                    composable(
                        AuthPageState.FORGOT_PASSWORD.name,
                        content = {
                            ForgotPasswordContent(navController = navController)
                            authPageState = AuthPageState.FORGOT_PASSWORD
                        }
                    )
                }
            )
        }
    }
}
