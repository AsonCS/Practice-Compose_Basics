package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

@Composable
fun TaskManagerApp() {
    TaskManagerScreen()
}

@Composable
private fun TaskManagerScreen() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(drawable.ic_task_completed),
                contentDescription = stringResource(string.task_manager_screen_image_content_description)
            )
            Text(
                text = stringResource(string.task_manager_screen_all_done),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        top = 24.dp,
                        bottom = 8.dp
                    )
            )
            Text(
                text = stringResource(string.task_manager_screen_nice_work),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TaskManagerScreenPreview() {
    PracticeComposeBasicsTheme(
        isDarkTheme = false
    ) {
        TaskManagerScreen()
    }
}
