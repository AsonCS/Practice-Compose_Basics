package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.model.Screen
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark

// region Composable

@Composable
fun LemonadeApp() {
    var screen by remember {
        mutableStateOf<Screen>(Screen.Screen1LemonTree)
    }
    var times by remember {
        mutableStateOf(0)
    }

    LemonadeScreen(
        onClick = {
            screen.let { currentScreen ->
                screen = when (currentScreen) {
                    Screen.Screen1LemonTree ->
                        Screen.Screen2Lemon()
                    is Screen.Screen2Lemon -> {
                        if (times < currentScreen.timesNeeded) {
                            times++
                            return@let
                        } else {
                            times = 0
                            Screen.Screen3GlassOfLemonade
                        }
                    }
                    Screen.Screen3GlassOfLemonade ->
                        Screen.Screen4EmptyGlass
                    Screen.Screen4EmptyGlass ->
                        Screen.Screen1LemonTree
                }
            }
        },
        screen = screen
    )
}

@Composable
private fun LemonadeScreen(
    screen: Screen,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(screen.title),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
        Image(
            painter = painterResource(screen.image),
            contentDescription = stringResource(screen.contentDescription),
            modifier = Modifier
                .border(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = MaterialTheme.shapes.extraLarge,
                    width = 4.dp
                )
                .clickable(onClick = onClick)
                .padding(32.dp)
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
private fun LemonadeScreenPreview() {
    Preview {
        LemonadeScreen(
            screen = Screen.Screen3GlassOfLemonade
        )
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun LemonadeScreenDarkPreview() {
    PreviewDark {
        LemonadeScreen(
            screen = Screen.Screen3GlassOfLemonade
        )
    }
}

// endregion
