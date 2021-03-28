package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.component.setStatusBarTransparent
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray900
import com.example.androiddevchallenge.ui.theme.yellow

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                setStatusBarTransparent(window = window)
                WelcomeScreen()
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        BackgroundImage()

        LogoImage()

        CtaButton()

    }
}

@Composable
private fun CtaButton() {
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .width(48.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                .weight(1f)
        ) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = yellow,
                    contentColor = gray900
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "GET STARTED")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = { },
                border = BorderStroke(1.dp, yellow),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = yellow
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}

@Composable
private fun LogoImage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            alignment = Alignment.Center
        )
    }
}

@Composable
private fun BackgroundImage() {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
        imageVector = ImageVector.vectorResource(id = R.drawable.welcome_bg),
        contentDescription = null,
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen()
    }
}