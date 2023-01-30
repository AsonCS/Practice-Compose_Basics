package com.example.practice_composebasics.model

import androidx.annotation.DrawableRes
import com.example.practice_composebasics.R

internal sealed class DiceFace(
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

internal fun randomDiceFace(
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
