package com.example.practice_composebasics.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.model.imageListSize
import com.example.practice_composebasics.model.webbTelescopeImageList
import com.example.practice_composebasics.ui.*

// region Composable

@Composable
fun ArtSpaceApp(
    windowWidth: WindowWidthSize,
) {
    logD("ArtSpaceApp")

    val viewModel = viewModel<MainViewModel>()

    ArtSpaceScreen(
        webbTelescopeImageState = viewModel.webbTelescopeImageState,
        windowWidth = windowWidth
    )
}

@Composable
private fun ArtSpaceScreen(
    webbTelescopeImageState: MutableState<Int>,
    windowWidth: WindowWidthSize
) {
    logD("ArtSpaceScreen")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            alignment = Alignment.CenterVertically,
            space = 16.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        if (windowWidth == WindowWidthSize.Expanded) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.CenterHorizontally,
                    space = 32.dp
                ),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ArtImage(
                    webbTelescopeImageState = webbTelescopeImageState,
                    windowWidth = windowWidth,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        } else {
            ArtImage(
                webbTelescopeImageState = webbTelescopeImageState,
                windowWidth = windowWidth,
                modifier = Modifier
            )
        }
    }
}

@Composable
private fun ArtImage(
    webbTelescopeImageState: MutableState<Int>,
    windowWidth: WindowWidthSize,
    modifier: Modifier
) {
    logD("ArtImage")

    var webbTelescopeImage by remember {
        webbTelescopeImageState
    }
    val image = webbTelescopeImageList[webbTelescopeImage]

    Surface(
        border = BorderStroke(
            color = MaterialTheme.colorScheme.primary,
            width = 4.dp
        ),
        shadowElevation = 8.dp,
        modifier = if (windowWidth == WindowWidthSize.Expanded)
            modifier
                .fillMaxHeight()
        else
            modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
    ) {
        val fallback = painterResource(image.fallbackImage)
        AsyncImage(
            contentDescription = image.title,
            error = fallback,
            fallback = fallback,
            model = image.image.takeIf { it.isNotEmpty() },
            contentScale = ContentScale.Crop,
            placeholder = fallback,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        )
    }
    Column(
        modifier = if (windowWidth == WindowWidthSize.Expanded)
            modifier
                .fillMaxWidth(0.4f)
        else
            modifier
                .fillMaxWidth()
    ) {
        Surface(
            shadowElevation = 8.dp
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.CenterVertically,
                    space = 8.dp
                ),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium,
                    text = image.title
                )
                Text(
                    text = image.releaseDate
                )
                SourceLink(
                    source = image.source
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterHorizontally,
                space = 32.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Button(
                onClick = {
                    webbTelescopeImage = if (webbTelescopeImage == 0)
                        imageListSize
                    else
                        webbTelescopeImage - 1
                }
            ) {
                Text(stringResource(string.art_space_screen_previous_button))
            }
            Button(
                onClick = {
                    webbTelescopeImage =
                        if (webbTelescopeImage == imageListSize)
                            0
                        else
                            webbTelescopeImage + 1
                }
            ) {
                Text(stringResource(string.art_space_screen_next_button))
            }
        }
    }

}

@Composable
private fun SourceLink(
    source: String
) {
    logD("SourceLink")

    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(
            tag = "url",
            annotation = source
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
            )
        ) {
            append("https://webbtelescope.org")
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current
    ClickableText(
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = "url",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }
        },
        style = MaterialTheme.typography.bodyMedium.copy(
            textDecoration = TextDecoration.Underline
        ),
        text = annotatedString,
    )
}

// endregion

// region Preview

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TipTimeScreenPreview() {
    Preview {
        ArtSpaceScreen(
            webbTelescopeImageState = mutableStateOf(0),
            windowWidth = WindowWidthSize.Compact
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TipTimeScreenDarkPreview() {
    PreviewDark {
        ArtSpaceScreen(
            webbTelescopeImageState = mutableStateOf(0),
            windowWidth = WindowWidthSize.Compact
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 601,
    showBackground = true,
    widthDp = 962
)
@Composable
private fun TipTimeScreenTabletPreview() {
    Preview {
        ArtSpaceScreen(
            webbTelescopeImageState = mutableStateOf(0),
            windowWidth = WindowWidthSize.Expanded
        )
    }
}

// endregion
