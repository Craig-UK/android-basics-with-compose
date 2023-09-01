package com.justcraigdev.businesscard

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justcraigdev.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayApp()
                }
            }
        }
    }
}

@Composable
fun DisplayApp(modifier: Modifier = Modifier) {
    val AppIcons = Icons.Rounded

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeadLine(name = stringResource(R.string.name), title = stringResource(R.string.title))
        Column(
            modifier = modifier
                .padding(top = 150.dp)
        ) {
            Row {
                Contact(icon = AppIcons.Email, iconDescription = stringResource(R.string.email_icon_description), text = stringResource(
                    R.string.email_text
                )
                )
            }
            Row {
                Contact(
                    icon = AppIcons.Home,
                    iconDescription = stringResource(R.string.social_media_icon_description),
                    text = stringResource(R.string.social_media_text)
                )
            }
            Row {
                Contact(
                    icon = AppIcons.AccountCircle,
                    iconDescription = stringResource(R.string.github_icon_description),
                    text = stringResource(R.string.github_text)
                )
            }
        }
    }
}

@Composable
private fun HeadLine(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

        Image(
            painter = image,
            contentDescription = "Android Logo"
        )

        Text(
            text = "$name",
            modifier = modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Text(
            text = "$title",
            modifier = modifier
                .padding(top = 5.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
}

@Composable
private fun Contact(icon: ImageVector, iconDescription: String, text: String, modifier: Modifier = Modifier) {
        Icon(
            icon,
            contentDescription = "$iconDescription"
        )
        Text(
            text = "$text",
            modifier = modifier
                .padding(start = 4.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun DisplayAppPreview() {
    BusinessCardTheme {
        DisplayApp()
    }
}