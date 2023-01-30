package com.example.practice_composebasics.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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

enum class WindowWidthSize {
    Compact,
    Expanded,
    Medium
}

fun WindowWidthSizeClass.toWindowWidthSize(): WindowWidthSize {
    return when (this) {
        WindowWidthSizeClass.Compact ->
            WindowWidthSize.Compact
        WindowWidthSizeClass.Expanded ->
            WindowWidthSize.Expanded
        WindowWidthSizeClass.Medium ->
            WindowWidthSize.Medium
        else ->
            WindowWidthSize.Compact
    }
}

