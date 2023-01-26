package com.example.practice_composebasics.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun MainButton(
    toggleScreen: () -> Unit,
    toggleTheme: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(
                end = 32.dp,
                bottom = 32.dp
            )
    ) {
        TextButton(
            onClick = {
                toggleScreen()
            }
        ) {
            Text(stringResource(R.string.app_main_screen_button_toggle_screen))
        }
        TextButton(
            onClick = {
                toggleTheme()
            }
        ) {
            Text(stringResource(R.string.app_main_screen_button_toggle_theme))
        }
    }

}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun MainButtonPreview() {
    PracticeComposeBasicsTheme(
        isDarkTheme = false
    ) {
        Box {
            MainButton(
                toggleScreen = {},
                toggleTheme = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }
    }
}
