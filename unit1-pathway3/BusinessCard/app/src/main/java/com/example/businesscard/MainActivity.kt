package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFFD2E8D4))
    ) {
        NameAndTitle(
            name = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            modifier = Modifier.weight(1F)
        )

        DeveloperInfoCard(
        )
    }
}

@Composable
fun NameAndTitle(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(Color.Black)
                .width(120.dp)
                .height(120.dp)
        )
        Text(
            text = name,
            fontSize = 48.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.green),
        )
    }
}

@Composable
fun DeveloperInfoCard() {
    // To center the content
    Column(
        modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // use this column to align content at the start
        // If I remove this Column, then all three texts are not properly aligned at Start
        Column {
            TextWithIcon(
                text = stringResource(id = R.string.phone_number),
                icon = painterResource(id = R.drawable.baseline_phone),
            )
            TextWithIcon(
                text = stringResource(id = R.string.social_media_handle),
                icon = painterResource(id = R.drawable.baseline_share),
            )
            TextWithIcon(
                text = stringResource(id = R.string.email),
                icon = painterResource(id = R.drawable.baseline_mail),
            )
        }
    }
}

@Composable
fun TextWithIcon(text: String, icon: Painter, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = colorResource(id = R.color.green)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}