package com.example.practice_composebasics.ui.screen

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.model.Hero
import com.example.practice_composebasics.model.HeroesRepository
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark

// region Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp() {
    Scaffold(
        topBar = {
            HeroTopBar()
        }
    ) {
        HeroesScreen(
            modifier = Modifier
                .padding(it)
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun HeroesScreen(
    modifier: Modifier = Modifier,
    heroes: List<Hero> = HeroesRepository.heroes
) {
//    val visibleState = remember {
//        MutableTransitionState(false).apply {
//            // Start the animation immediately.
//            targetState = true
//        }
//    }

//    // Fade in entry animation for the entire list
//    AnimatedVisibility(
//        visibleState = visibleState,
//        enter = fadeIn(
//            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
//        ),
//        exit = fadeOut()
//    ) {
    LazyColumn(
        contentPadding = PaddingValues(
            16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(
            8.dp
        ),
        modifier = modifier
    ) {
        itemsIndexed(heroes) { index, hero ->
            HeroItem(
                hero = hero,
                modifier = Modifier
//                        // Animate each list item to slide in vertically
//                        .animateEnterExit(
//                            enter = slideInVertically(
//                                animationSpec = spring(
//                                    stiffness = StiffnessVeryLow,
//                                    dampingRatio = DampingRatioLowBouncy
//                                ),
//                                initialOffsetY = { it * (index + 1) } // staggered entrance
//                            )
//                        )
            )
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(96.dp)
            )
        }
    }
//    }
}

@Composable
private fun HeroTopBar() {
    Text(
        style = MaterialTheme.typography.displaySmall,
        text = stringResource(string.heroes_screen_name),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
private fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    style = MaterialTheme.typography.titleSmall,
                    text = stringResource(hero.name)
                )
                Text(stringResource(hero.description))
            }
            Image(
                contentDescription = null,
                contentScale = ContentScale.Crop,
                painter = painterResource(hero.image),
                modifier = Modifier
                    .sizeIn(
                        maxHeight = 96.dp,
                        maxWidth = 96.dp,
                        minHeight = 40.dp,
                        minWidth = 40.dp
                    )
                    .clip(RoundedCornerShape(8.dp))
            )
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
private fun HeroesScreenPreview() {
    Preview {
        HeroesScreen()
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun HeroesScreenDarkPreview() {
    PreviewDark {
        HeroesScreen()
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 601,
    showBackground = true,
    widthDp = 962
)
@Composable
private fun HeroesScreenTabletPreview() {
    Preview {
        HeroesScreen()
    }
}

// endregion
