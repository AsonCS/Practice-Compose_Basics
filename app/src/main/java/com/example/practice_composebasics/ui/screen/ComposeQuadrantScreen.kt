package com.example.practice_composebasics.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

// region Composable

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
                color = Color.Green,
                title = string.compose_quadrant_screen_first_title,
                subtitle = string.compose_quadrant_screen_first_subtitle,
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                color = Color.Yellow,
                title = string.compose_quadrant_screen_second_title,
                subtitle = string.compose_quadrant_screen_second_subtitle,
                modifier = Modifier
                    .weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Quadrant(
                color = Color.Cyan,
                title = string.compose_quadrant_screen_third_title,
                subtitle = string.compose_quadrant_screen_third_subtitle,
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                color = Color.LightGray,
                title = string.compose_quadrant_screen_forth_title,
                subtitle = string.compose_quadrant_screen_forth_subtitle,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun Quadrant(
    color: Color,
    @StringRes title: Int,
    @StringRes subtitle: Int,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .border(
                border = BorderStroke(
                    width = 8.dp,
                    color = color
                ),
                shape = MaterialTheme.shapes.large
            )
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(
            modifier = Modifier
                .background(color)
                .fillMaxWidth()
                .height(64.dp)
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = stringResource(title),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 16.dp
                )
        )
        Text(
            text = stringResource(subtitle),
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 16.dp
                )
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Spacer(
            modifier = Modifier
                .background(color)
                .fillMaxWidth()
                .height(64.dp)
        )
    }
}

// endregion

// region Preview

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

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun ComposeQuadrantScreenDarkPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = true
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ComposeQuadrantScreen()
        }
    }
}

// endregion
