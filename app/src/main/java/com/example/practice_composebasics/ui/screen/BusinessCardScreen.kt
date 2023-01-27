package com.example.practice_composebasics.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun BusinessCardApp() {
    BusinessCardScreen()
}

@Composable
private fun BusinessCardScreen(
    person: Person = Person()
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = person.logo,
                contentDescription = stringResource(string.compose_business_card_screen_logo_content_description),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
            )
            Text(
                text = person.fullName,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Text(
                text = person.role,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 128.dp)
        ) {
            InfoLine(
                contentDescription = string.app_name,
                info = person.phoneNumber,
                imageVector = Icons.Rounded.Phone
            )
            InfoLine(
                contentDescription = string.app_name,
                info = person.userName,
                imageVector = Icons.Rounded.Share
            )
            InfoLine(
                contentDescription = string.app_name,
                info = person.email,
                imageVector = Icons.Rounded.Email
            )
        }
    }
}

@Composable
private fun InfoLine(
    @StringRes contentDescription: Int,
    info: String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = stringResource(contentDescription),
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(start = 36.dp)
                .wrapContentWidth()
                .weight(1f)
        )
        Text(
            text = info,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(4f)
        )
    }
}

data class Person(
    val logo: ImageVector = Icons.Filled.Person,
    val fullName: String = "Anderson Costa da Silva",
    val role: String = "Android Developer, Fullstack",
    val phoneNumber: String = "+55 11 91234-5678",
    val userName: String = "AsonCS",
    val email: String = "asoncs@gamil.com"
)

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun BusinessCardScreenPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = false
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCardScreen()
        }
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun BusinessCardScreenDarkPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = true
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCardScreen()
        }
    }
}
