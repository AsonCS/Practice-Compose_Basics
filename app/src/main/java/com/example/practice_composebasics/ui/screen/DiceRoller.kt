package com.example.practice_composebasics.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_composebasics.R
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun DiceRollerApp() {
    var diceFace by remember {
        mutableStateOf(
            randomDiceFace().first
        )
    }
    var lastValues by remember {
        mutableStateOf(
            listOf<Int>()
        )
    }

    DiceRollerScreen(
        diceFace = diceFace,
        lastValues = lastValues,
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
private fun DiceRollerScreen(
    diceFace: DiceFace = DiceFace.Six,
    lastValues: List<Int> = listOf(),
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.historic).also {
                android.util.Log.d("ComposeBasics", "text = stringResource(R.string.historic)")
            },
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(8.dp)
        )
        Text(
            text = lastValues.joinToString(
                separator = ", "
            )
        )
        Image(
            painter = painterResource(diceFace.image).also {
                android.util.Log.d("ComposeBasics", "painter = painterResource(diceFace.image)")
            },
            contentDescription = diceFace.contentDescription
        )
        Spacer(
            modifier = Modifier
                .height(48.dp)
        )
        Button(
            onClick = onClick
        ) {
            Text(
                text = stringResource(R.string.button_roll_text).also {
                    android.util.Log.d("ComposeBasics", "text = stringResource(R.string.button_roll_text)")
                },
                fontSize = 48.sp
            )
        }.also {
            android.util.Log.d("ComposeBasics", "Button(")
        }
    }
}

private sealed class DiceFace(
    val contentDescription: String,
    @DrawableRes val image: Int,
    val value: Int
) {
    object One : DiceFace(
        contentDescription = "Face 1",
        image = R.drawable.dice_1,
        value = 1
    )

    object Two : DiceFace(
        contentDescription = "Face 2",
        image = R.drawable.dice_2,
        value = 2
    )

    object Three : DiceFace(
        contentDescription = "Face 3",
        image = R.drawable.dice_3,
        value = 3
    )

    object Four : DiceFace(
        contentDescription = "Face 4",
        image = R.drawable.dice_4,
        value = 4
    )

    object Five : DiceFace(
        contentDescription = "Face 5",
        image = R.drawable.dice_5,
        value = 5
    )

    object Six : DiceFace(
        contentDescription = "Face 6",
        image = R.drawable.dice_6,
        value = 6
    )
}

private fun randomDiceFace(
    currentDiceFace: DiceFace? = null,
    lastValues: MutableList<Int> = mutableListOf()
): Pair<DiceFace, List<Int>> {
    if (lastValues.size > 9) {
        lastValues.removeAt(0)
    }
    currentDiceFace?.value?.let {
        lastValues.add(it)
    }
    val diceFace = when ((1..6).random()) {
        DiceFace.One.value ->
            DiceFace.One
        DiceFace.Two.value ->
            DiceFace.Two
        DiceFace.Three.value ->
            DiceFace.Three
        DiceFace.Four.value ->
            DiceFace.Four
        DiceFace.Five.value ->
            DiceFace.Five
        else ->
            DiceFace.Six
    }
    return Pair(diceFace, lastValues)
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun DiceRollerScreenPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = false
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DiceRollerScreen()
        }
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun DiceRollerScreenDarkPreview() {
    PracticeComposeBasicsTheme(
        useDarkTheme = true
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DiceRollerScreen()
        }
    }
}
