package com.example.practice_composebasics

import com.example.practice_composebasics.ui.screen.tipValueCalculator
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipValueCalculatorTest {

    @Test
    fun `When tip percent is 20 and the cost is 10 without roundup should return 2`() {
        val expectedTip = NumberFormat
            .getCurrencyInstance()
            .format(2)

        val actualTip = tipValueCalculator(
            costAmount = "10.0",
            roundUp = false,
            tipPercent = "20.0",
        )

        assertEquals(
            expectedTip,
            actualTip
        )
    }

}
