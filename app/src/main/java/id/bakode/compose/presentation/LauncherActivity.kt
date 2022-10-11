package id.bakode.compose.presentation

import android.content.Intent
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import id.bakode.compose.presentation.auth.AuthenticationActivity
import id.bakode.compose.ui.component.ExpComposeBackground
import id.bakode.compose.ui.theme.*
import kotlinx.coroutines.delay

@ExperimentalMaterial3Api
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { LauncherContent() }

        this@LauncherActivity.navigateNextPage()
    }

    private fun navigateNextPage() {
        lifecycleScope.launchWhenCreated {
            delay(3000L)

            startActivity(Intent(
                this@LauncherActivity,
                AuthenticationActivity::class.java
            ))

            finish()
        }
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
fun LauncherContent() {
    ExpComposeTheme {
        ExpComposeBackground {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = getDrawableLogo()),
                    contentDescription = "BAKODE_LOGO",
                    modifier = Modifier
                        .requiredSize(125.dp)
                        .padding(21.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
                Text(
                    text = "Karlota Messenger",
                    modifier = Modifier.padding(4.dp),
                    style = Typography.titleLarge,
                    color = getThemeColor()
                )
                Text(
                    text = "by BAKODE.ID",
                    style = Typography.bodySmall,
                    color = getThemeColor()
                )
            }
        }
    }
}
