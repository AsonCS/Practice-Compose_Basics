package com.example.practice_composebasics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
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
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark

// region Composable

@Composable
fun TaskManagerApp() {
    TaskManagerScreen()
}

@Composable
private fun TaskManagerScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(drawable.ic_task_completed),
            contentDescription = stringResource(string.task_manager_screen_image_content_description)
        )
        Text(
            text = stringResource(string.task_manager_screen_all_done),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
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

// endregion

// region Preview

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TaskManagerScreenPreview() {
    Preview {
        TaskManagerScreen()
    }
}

@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun TaskManagerScreenDarkPreview() {
    PreviewDark {
        TaskManagerScreen()
    }
}

// endregion
