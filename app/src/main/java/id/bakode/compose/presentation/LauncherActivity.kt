package id.bakode.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.bakode.compose.ui.component.ExpComposeBackground
import id.bakode.compose.ui.theme.ExpComposeTheme
import id.bakode.compose.ui.theme.Typography
import id.bakode.compose.ui.theme.getDrawableLogo

class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpComposeTheme {
                ExpComposeBackground {
                    LauncherContent()
                }
            }
        }
    }
}

@Composable
fun LauncherContent() {
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
            style = Typography.titleLarge
        )
        Text(
            text = "by BAKODE.ID",
            style = Typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpComposeTheme {
        ExpComposeBackground {
            LauncherContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    ExpComposeTheme(
        darkTheme =  false,
        dynamicColor = false
    ) {
        ExpComposeBackground {
            LauncherContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    ExpComposeTheme(
        darkTheme =  true,
        dynamicColor = false
    ) {
        ExpComposeBackground {
            LauncherContent()
        }
    }
}