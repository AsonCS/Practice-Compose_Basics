package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun ComposeArticleApp() {
    ComposeArticleScreen()
}

@Composable
private fun ComposeArticleScreen() {
    Column(
        Modifier
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(drawable.bg_compose_background),
            contentDescription = stringResource(string.compose_article_screen_image_content_description)
        )
        ComposeArticleBody(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                )
        )
    }
}

@Composable
private fun ComposeArticleBody(
    modifier: Modifier
) {
    Text(
        text = stringResource(string.compose_article_screen_title),
        style = MaterialTheme.typography.h1,
        modifier = modifier
    )
    Text(
        text = stringResource(string.compose_article_screen_subtitle),
        modifier = modifier
    )
    Text(
        text = stringResource(string.compose_article_screen_text),
        modifier = modifier
    )
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun ComposeArticleScreenPreview() {
    PracticeComposeBasicsTheme(
        isDarkTheme = false
    ) {
        ComposeArticleScreen()
    }
}
