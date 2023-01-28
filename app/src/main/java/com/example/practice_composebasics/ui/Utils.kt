package com.example.practice_composebasics.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

fun logD(message: String) {
    android.util.Log.d("ComposeBasicsTag", message)
}

@Composable
fun Preview(
    content: @Composable () -> Unit
) {
    PracticeComposeBasicsTheme(
        useDarkTheme = false
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun PreviewDark(
    content: @Composable () -> Unit
) {
    PracticeComposeBasicsTheme(
        useDarkTheme = true
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
