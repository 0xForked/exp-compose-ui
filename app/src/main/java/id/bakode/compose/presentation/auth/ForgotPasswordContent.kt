@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)

package id.bakode.compose.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import id.bakode.compose.ui.theme.Typography
import id.bakode.compose.ui.theme.getDrawableLogo
import id.bakode.compose.ui.theme.getTextButtonColor
import id.bakode.compose.ui.theme.getThemeColor

@Composable
fun ForgotPasswordContent(navController: NavController) {
    Box(Modifier.padding(32.dp)) {
        FloatingActionButton(
            modifier = Modifier.size(40.dp),
            onClick = { navController.popBackStack() },
            containerColor = getThemeColor()
        ) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = null,
                tint = getTextButtonColor()
            )
        }
    }

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
                    text = "Forgot? \uD83D\uDC40",
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

        Column(modifier = Modifier.padding(horizontal = 32.dp)) {
            ExpComposeForm(
                label = "Email",
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpComposeButton(text = "Forgot Password", action = {
                println("LEME RESET PASSWORD")
            })
        }
    }
}
