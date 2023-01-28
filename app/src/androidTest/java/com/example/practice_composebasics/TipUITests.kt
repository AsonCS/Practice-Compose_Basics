package com.example.practice_composebasics

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.screen.TipTimeApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_tip_percent_is_20_and_the_cost_is_10_without_roundup_should_return_2() {
        val expectedTip = NumberFormat
            .getCurrencyInstance()
            .format(2)

        composeTestRule.setContent {
            Preview {
                TipTimeApp()
            }
        }
        composeTestRule.onNodeWithText("Cost of Service")
            .performTextInput("10")
        composeTestRule.onNodeWithContentDescription("Tip (%)")
            .performTextClearance()
        composeTestRule.onNodeWithContentDescription("Tip (%)")
            .performTextInput("20")

        composeTestRule.onNodeWithText(
            text = "Tip amount:",
            substring = true
        ).assertExists(
            "No node with this text was found."
        )
        composeTestRule.onNodeWithText(
            text = expectedTip,
            substring = true
        ).assertExists(
            "No node with this text was found."
        )

        runBlocking {
            delay(3000)
        }
    }

}
