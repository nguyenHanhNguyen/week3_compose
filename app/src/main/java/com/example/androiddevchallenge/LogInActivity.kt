package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.component.setStatusBarTransparent
import com.example.androiddevchallenge.ui.theme.MyTheme

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                setStatusBarTransparent(window = window)
                LogInScreen()
            }
        }
    }
}

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

            EmailTextField(email, setEmail)

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
private fun PasswordTextField(
    password: String,
    setPassword: (String) -> Unit
) {
    OutlinedTextField(
        value = password,
        onValueChange = setPassword,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(0.9f)
            .height(56.dp),
        label = {
            Text(
                text = "Password",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password_24px),
                contentDescription = "Password icon"
            )
        }
    )
}

@Composable
private fun EmailTextField(email: String, setEmail: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = setEmail,
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth(0.9f)
            .height(56.dp),
        label = {
            Text(
                text = "Email Address",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_mail_outline_24px),
                contentDescription = "Email outline"
            )
        }
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