package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
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
    Column {
        Column {
            Image(
                imageVector = person.logo,
                contentDescription = stringResource(string.compose_business_card_screen_logo_content_description),
                modifier = Modifier.size(180.dp)
            )
            Text(
                text = person.fullName,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = person.role,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column {
            Row {
                Icon(
                    imageVector = Icons.Rounded.Phone,
                    contentDescription = stringResource(string.app_name)
                )
                Text(
                    text = person.phoneNumber,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = stringResource(string.app_name)
                )
                Text(
                    text = person.userName,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = stringResource(string.app_name)
                )
                Text(
                    text = person.email,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

data class Person(
    val logo: ImageVector = Icons.Filled.Face,
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
        BusinessCardScreen()
    }
}
