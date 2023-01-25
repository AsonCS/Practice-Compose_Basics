package com.example.practice_composebasics.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun ComposeArticleApp() {
    val viewModel = viewModel<MainViewModel>()

    ComposeArticleScreen(
        navigateToComposeArticle = viewModel::navigateToComposeArticle
    )
}

@Composable
private fun ComposeArticleScreen(
    navigateToComposeArticle: () -> Unit
) {
    Column {
        Image(
            painter = painterResource(
                id = drawable.bg_compose_background
            ),
            contentDescription = stringResource(string.compose_article_screen_image_content_description)
        )
        Text(
            text = stringResource(string.compose_article_screen_title)
        )
        Text(
            text = stringResource(string.compose_article_screen_subtitle)
        )
        Text(
            text = stringResource(string.compose_article_screen_text)
        )
        TextButton(
            onClick = { navigateToComposeArticle() }
        ) {
            Text(text = "fgdsfhjgçldfjgldçf")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320
)
@Composable
fun DefaultPreview() {
    PracticeComposeBasicsTheme {
        ComposeArticleScreen(
            navigateToComposeArticle = {}
        )
    }
}