package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LogInScreen() {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            BackgroundContent()

            Spacer(Modifier.height(40.dp))

            EmailTextField(email, setEmail)

            Spacer(Modifier.height(8.dp))

            PasswordTextField(password, setPassword)
        }
    }
}

@Composable
private fun BackgroundContent() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = "Welcome\nback",
            style = MaterialTheme.typography.h2,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(152.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun EmailTextField(email: String, setEmail: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = setEmail,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(56.dp),
        label = {
            Text(
                text = "Email Address",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_mail_outline_24px),
                contentDescription = "Email outline"
            )
        },
    )
}

@Composable
private fun PasswordTextField(
    password: String,
    setPassword: (String) -> Unit
) {
    OutlinedTextField(
        value = password,
        onValueChange = setPassword,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(56.dp),
        label = {
            Text(
                text = "Password",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password_24px),
                contentDescription = "Password icon"
            )
        },
    )
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LogInLightPreview() {
    MyTheme {
        LogInScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LogInDarkPreview() {
    MyTheme(darkTheme = true) {
        LogInScreen()
    }
}