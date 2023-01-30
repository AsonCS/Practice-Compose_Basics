package com.example.practice_composebasics.model

import androidx.annotation.VisibleForTesting
import java.text.NumberFormat

internal fun String.onlyNumbers(): String {
    return replace(
        regex = "[^0-9^\\.]".toRegex(),
        replacement = ""
    )
}

@VisibleForTesting
internal fun tipValueCalculator(
    costAmount: String,
    roundUp: Boolean,
    tipPercent: String
): String {
    val costValue = costAmount.toDoubleOrNull()
        ?: 0.0
    val tipValue = tipPercent.toDoubleOrNull()
        ?: 0.0

    var tip = tipValue / 100 * costValue
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }

    return NumberFormat
        .getCurrencyInstance()
        .format(tip)
}
