package id.bakode.compose.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun ExpComposeForm(
    modifier: Modifier = Modifier,
    label: String,
    imeAction: ImeAction,
    keyboardType: KeyboardType,
    passwordField: Boolean = false,
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val togglePassword = rememberSaveable { mutableStateOf(true) }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        visualTransformation = if (passwordField && togglePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (passwordField) {
                IconButton(onClick = { togglePassword.value = !togglePassword.value }) {
                    val visibilityIcon =
                        if (togglePassword.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (togglePassword.value) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            }
        }
    )
}