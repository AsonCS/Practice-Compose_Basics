package com.example.practice_composebasics.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.model.webbTelescopeImageList
import com.example.practice_composebasics.ui.*

// region Composable

@Composable
fun Screen11CreateA30DaysApp(
    windowWidth: WindowWidthSize,
) {
    Screen11CreateA30DaysScreen(
        windowWidth = windowWidth
    )
}

@Composable
private fun Screen11CreateA30DaysScreen(
    windowWidth: WindowWidthSize
) {
    logD("ArtSpaceScreen")

    LazyRow(
        modifier = Modifier
//            .fillMaxSize()
    ) {
        items(webbTelescopeImageList) { image ->
            if (windowWidth == WindowWidthSize.Expanded) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        alignment = Alignment.CenterHorizontally,
                        space = 32.dp
                    ),
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(32.dp)
                ) {
                    ArtImage(
                        image = image,
                        windowWidth = windowWidth,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        alignment = Alignment.CenterVertically,
                        space = 16.dp
                    ),
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(32.dp)
                ) {
                    ArtImage(
                        image = image,
                        windowWidth = windowWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
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
private fun Screen11CreateA30DaysScreenPreview() {
    Preview {
        Screen11CreateA30DaysScreen(
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
private fun Screen11CreateA30DaysScreenDarkPreview() {
    PreviewDark {
        Screen11CreateA30DaysScreen(
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
private fun Screen11CreateA30DaysScreenTabletPreview() {
    Preview {
        Screen11CreateA30DaysScreen(
            windowWidth = WindowWidthSize.Expanded
        )
    }
}

// endregion
