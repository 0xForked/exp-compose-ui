@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)

package id.bakode.compose.presentation.auth

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.bakode.compose.ui.component.ExpComposeBackground
import id.bakode.compose.ui.theme.ExpComposeTheme
import id.bakode.compose.ui.theme.Typography
import id.bakode.compose.ui.theme.getDrawableLogo
import id.bakode.compose.ui.theme.getThemeColor
import id.bakode.compose.util.enums.AuthPageState

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
    var pageState: AuthPageState = AuthPageState.LOGIN

    ExpComposeTheme {
        ExpComposeBackground {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )  {
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
                            text = getCurrentPageTitle(pageState),
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

               GetCurrentPageContent(pageState)
            }
        }
    }
}


@Composable
fun GetCurrentPageContent(pageState: AuthPageState) {
    val pageContent = when(pageState) {
        AuthPageState.LOGIN -> SignInContent()
        AuthPageState.REGISTER -> SignUpContent()
        AuthPageState.FORGOT_PASSWORD -> ForgotPasswordContent()
    }

    return pageContent
}

fun getCurrentPageTitle(pageState: AuthPageState): String {
    val pageTitle = when(pageState) {
        AuthPageState.LOGIN -> "Sign In \uD83E\uDDD0"
        AuthPageState.REGISTER -> "Sign Up \uD83D\uDE0E"
        AuthPageState.FORGOT_PASSWORD -> "Forgot? \uD83D\uDC40"
    }

    return pageTitle
}