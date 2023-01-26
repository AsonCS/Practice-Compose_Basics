package com.example.practice_composebasics.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun ComposeQuadrantApp() {
    ComposeQuadrantScreen()
}

@Composable
private fun ComposeQuadrantScreen() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Quadrant(
                title = string.compose_quadrant_screen_first_title,
                subtitle = string.compose_quadrant_screen_first_subtitle,
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Quadrant(
                title = string.compose_quadrant_screen_second_title,
                subtitle = string.compose_quadrant_screen_second_subtitle,
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Quadrant(
                title = string.compose_quadrant_screen_third_title,
                subtitle = string.compose_quadrant_screen_third_subtitle,
                modifier = Modifier
                    .background(Color.Cyan)
                    .weight(1f)
            )
            Quadrant(
                title = string.compose_quadrant_screen_forth_title,
                subtitle = string.compose_quadrant_screen_forth_subtitle,
                modifier = Modifier
                    .background(Color.LightGray)
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun Quadrant(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(title),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(subtitle),
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun ComposeQuadrantScreenPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = false
    ) {
        ComposeQuadrantScreen()
    }
}
