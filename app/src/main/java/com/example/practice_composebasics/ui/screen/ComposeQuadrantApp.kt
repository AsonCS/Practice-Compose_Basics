package com.example.practice_composebasics.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.string

@Composable
fun ComposeQuadrantApp() {
    ComposeQuadrantScreen()
}

@Composable
private fun ComposeQuadrantScreen() {
    val modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    Column {
        Row(
            modifier = modifier
                .weight(1f)
        ) {
            Quadrant(
                title = string.compose_quadrant_screen_first_title,
                subtitle = string.compose_quadrant_screen_first_subtitle,
                modifier = modifier
                    .background(Color.Green)
                    .weight(1f)
            )
            Quadrant(
                title = string.compose_quadrant_screen_second_title,
                subtitle = string.compose_quadrant_screen_second_subtitle,
                modifier = modifier
                    .background(Color.Yellow)
                    .weight(1f)
            )
        }
        Row(
            modifier = modifier
                .weight(1f)
        ) {
            Quadrant(
                title = string.compose_quadrant_screen_third_title,
                subtitle = string.compose_quadrant_screen_third_subtitle,
                modifier = modifier
                    .background(Color.Cyan)
                    .weight(1f)
            )
            Quadrant(
                title = string.compose_quadrant_screen_forth_title,
                subtitle = string.compose_quadrant_screen_forth_subtitle,
                modifier = modifier
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
            .padding(16.dp)
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Text(
            text = stringResource(title),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(subtitle),
            color = Color.Black,
            textAlign = TextAlign.Justify
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
    ComposeQuadrantScreen()
}
