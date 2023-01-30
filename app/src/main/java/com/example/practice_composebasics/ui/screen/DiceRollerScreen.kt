package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.model.DiceFace
import com.example.practice_composebasics.model.randomDiceFace
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark
import com.example.practice_composebasics.ui.logD

// region Composable

@Composable
fun DiceRollerApp() {
    logD("DiceRollerApp")

    DiceRollerScreen()
}

@Composable
private fun DiceRollerScreen(
    initialDiceFace: DiceFace? = null,
    initialLastValues: List<Int>? = null
) {
    logD("DiceRollerScreen")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(string.dice_roller_screen_historic),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(8.dp)
        )
        DiceRollerContent(
            initialDiceFace = initialDiceFace,
            initialLastValues = initialLastValues
        )
    }
}

@Composable
private fun DiceRollerContent(
    initialDiceFace: DiceFace? = null,
    initialLastValues: List<Int>? = null
) {
    logD("DiceRollerContent")

    var diceFace by remember {
        mutableStateOf(
            initialDiceFace
                ?: randomDiceFace().first
        )
    }
    var lastValues by remember {
        mutableStateOf(
            initialLastValues
                ?: listOf()
        )
    }

    HistoricText(
        lastValues = lastValues
    )
    DiceImage(
        diceFace = diceFace
    )
    Spacer(
        modifier = Modifier
            .height(48.dp)
    )
    RollButton(
        onClick = {
            randomDiceFace(
                currentDiceFace = diceFace,
                lastValues = lastValues.toMutableList()
            ).let {
                diceFace = it.first
                lastValues = it.second
            }
        }
    )
}

@Composable
private fun HistoricText(
    lastValues: List<Int>
) {
    logD("HistoricText")

    Text(
        text = lastValues.joinToString(
            separator = ", "
        )
    )
}

@Composable
private fun DiceImage(
    diceFace: DiceFace
) {
    logD("DiceImage")

    Image(
        painter = painterResource(diceFace.image),
        contentDescription = diceFace.contentDescription
    )
}

@Composable
private fun RollButton(
    onClick: () -> Unit
) {
    logD("RollButton")

    Button(
        onClick = onClick
    ) {
        Text(
            text = stringResource(string.dice_roller_screen_button_roll_text),
            fontSize = 48.sp
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
private fun DiceRollerScreenPreview() {
    Preview {
        DiceRollerScreen(
            initialDiceFace = DiceFace.Six,
            initialLastValues = listOf(1, 3, 5, 6)
        )
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun DiceRollerScreenDarkPreview() {
    PreviewDark {
        DiceRollerScreen(
            initialDiceFace = DiceFace.Six,
            initialLastValues = listOf(1, 3, 5, 6)
        )
    }
}

// endregion
