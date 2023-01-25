package com.example.practice_composebasics.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_composebasics.R

@Composable
fun MainButton(
    modifier: Modifier
) {
    val viewModel = viewModel<MainViewModel>()

    TextButton(
        onClick = { viewModel.navigateToComposeArticle() },
        modifier = modifier
            .padding(end = 16.dp)
            .width(32.dp)
    ) {
        Text(stringResource(R.string.app_main_screen_toggle_button))
    }
}
