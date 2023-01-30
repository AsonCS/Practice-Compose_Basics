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
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string
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
    webbTelescopeImageState: MutableState<WebbTelescopeImage>,
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
        if (windowWidth == WindowWidthSize.Expanded)
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
        else
            ArtImage(
                webbTelescopeImageState = webbTelescopeImageState,
                windowWidth = windowWidth,
                modifier = Modifier
            )
    }
}

@Composable
private fun ArtImage(
    webbTelescopeImageState: MutableState<WebbTelescopeImage>,
    windowWidth: WindowWidthSize,
    modifier: Modifier
) {
    logD("ArtImage")

    var webbTelescopeImage by remember {
        webbTelescopeImageState
    }

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
        AsyncImage(
            contentDescription = webbTelescopeImage.title,
            error = painterResource(drawable.ic_launcher_foreground),
            fallback = painterResource(drawable.ic_launcher_foreground),
            model = webbTelescopeImage.image,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(drawable.ic_launcher_foreground),
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        )
    }
    Surface(
        shadowElevation = 8.dp
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterVertically,
                space = 8.dp
            ),
            modifier = if (windowWidth == WindowWidthSize.Expanded)
                modifier
                    .fillMaxWidth(0.4f)
                    .padding(16.dp)
            else
                modifier
                    .fillMaxWidth()
                    .padding(16.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayMedium,
                text = webbTelescopeImage.title
            )
            Text(
                text = webbTelescopeImage.releaseDate
            )
            SourceLink(
                source = webbTelescopeImage.source
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.CenterHorizontally,
                    space = 32.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        webbTelescopeImage = getPreviousWebbTelescopeImage(webbTelescopeImage)
                    }
                ) {
                    Text(stringResource(string.art_space_screen_previous_button))
                }
                Button(
                    onClick = {
                        webbTelescopeImage = getNextWebbTelescopeImage(webbTelescopeImage)
                    }
                ) {
                    Text(stringResource(string.art_space_screen_next_button))
                }
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

// region Model

private fun getNextWebbTelescopeImage(
    current: WebbTelescopeImage
): WebbTelescopeImage {
    return when (current) {
        WebbTelescopeImage.CosmicCliffs ->
            WebbTelescopeImage.CosmicCliffsComposite
        WebbTelescopeImage.CosmicCliffsComposite ->
            WebbTelescopeImage.ExoplanetLHS475
        WebbTelescopeImage.ExoplanetLHS475 ->
            WebbTelescopeImage.FirstDeepField
        WebbTelescopeImage.FirstDeepField ->
            WebbTelescopeImage.SouthernRingNebula
        WebbTelescopeImage.SouthernRingNebula ->
            WebbTelescopeImage.StephanQuintet
        WebbTelescopeImage.StephanQuintet ->
            WebbTelescopeImage.CosmicCliffs
    }
}

private fun getPreviousWebbTelescopeImage(
    current: WebbTelescopeImage
): WebbTelescopeImage {
    return when (current) {
        WebbTelescopeImage.CosmicCliffs ->
            WebbTelescopeImage.StephanQuintet
        WebbTelescopeImage.CosmicCliffsComposite ->
            WebbTelescopeImage.CosmicCliffs
        WebbTelescopeImage.ExoplanetLHS475 ->
            WebbTelescopeImage.CosmicCliffsComposite
        WebbTelescopeImage.FirstDeepField ->
            WebbTelescopeImage.ExoplanetLHS475
        WebbTelescopeImage.SouthernRingNebula ->
            WebbTelescopeImage.FirstDeepField
        WebbTelescopeImage.StephanQuintet ->
            WebbTelescopeImage.SouthernRingNebula
    }
}

sealed class WebbTelescopeImage(
    val image: String,
    val releaseDate: String,
    val source: String,
    val title: String
) {
    object CosmicCliffs : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01GA6KNV1S3TP2JBPCDT8G826T.png",
        releaseDate = "July 12, 2022 11:22AM (EDT)",
        source = "https://webbtelescope.org/contents/media/images/2022/031/01G77PKB8NKR7S8Z6HBXMYATGJ",
        title = "\"Cosmic Cliffs\" in the Carina Nebula (NIRCam Image)",
    )

    object CosmicCliffsComposite : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01G8GYE2PQWY96TDX66CHQRMPQ.png",
        releaseDate = "July 12, 2022 11:22AM (EDT)",
        source = "https://webbtelescope.org/contents/media/images/2022/031/01G780WF1VRADDSD5MDNDRKAGY",
        title = "\"Cosmic Cliffs\" in the Carina Nebula (NIRCam and MIRI Composite Image)",
    )

    object FirstDeepField : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01G8H1NK4W8CJYHF2DDFD1W0DQ.png",
        releaseDate = "July 12, 2022 10:39AM (EDT)",
        source = "https://webbtelescope.org/contents/media/images/2022/035/01G7DCWB7137MYJ05CSH1Q5Z1Z",
        title = "Webb's First Deep Field (NIRCam Image)",
    )

    object StephanQuintet : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01G8H4DRM2C010PX6T3DPEEDAW.png",
        releaseDate = "July 12, 2022 11:13AM (EDT)",
        source = "https://webbtelescope.org/contents/media/images/2022/034/01G7DA5ADA2WDSK1JJPQ0PTG4A",
        title = "Stephan's Quintet (NIRCam and MIRI Composite Image)",
    )

    object ExoplanetLHS475 : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01GNVTY9PE3VHJDW6GR9RHTHXX.png",
        releaseDate = "January 11, 2023 1:15PM (EST)",
        source = "https://webbtelescope.org/contents/media/images/2023/102/01GNVTTACCM2GA5P3B6S5EAMWD",
        title = "Exoplanet LHS 475 b and Its Star (Illustration)",
    )

    object SouthernRingNebula : WebbTelescopeImage(
        image = "https://stsci-opo.org/STScI-01GQ5CHESABWMHRF5NA60A6MPF.png",
        releaseDate = "January 23, 2023 11:00AM (EST)",
        source = "https://webbtelescope.org/contents/media/images/2023/106/01GQ2TJ92FQK45MY7JEYKWS834",
        title = "Chamaeleon I Molecular Cloud (NIRCam Image)",
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
            webbTelescopeImageState = mutableStateOf(WebbTelescopeImage.CosmicCliffs),
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
            webbTelescopeImageState = mutableStateOf(WebbTelescopeImage.CosmicCliffs),
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
            webbTelescopeImageState = mutableStateOf(WebbTelescopeImage.CosmicCliffs),
            windowWidth = WindowWidthSize.Expanded
        )
    }
}

// endregion
