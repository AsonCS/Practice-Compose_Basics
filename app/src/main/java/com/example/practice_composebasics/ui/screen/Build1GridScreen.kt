package com.example.practice_composebasics.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_composebasics.R
import com.example.practice_composebasics.model.Build1GridDataSource
import com.example.practice_composebasics.model.TopicInfo
import com.example.practice_composebasics.ui.Preview
import com.example.practice_composebasics.ui.PreviewDark

// region Composable

@Composable
fun Build1GridApp() {
    Build1GridScreen()
}

@Composable
private fun Build1GridScreen(
    topics: List<TopicInfo> = Build1GridDataSource.topics
) {
    TopicsGrid(topics)
}

@Composable
private fun TopicInfoCard(
    topicInfo: TopicInfo
) {
    Card(
        elevation = CardDefaults.cardElevation(
            8.dp
        )
    ) {
        Row {
            val name = stringResource(topicInfo.name)

            Image(
                contentDescription = name,
                contentScale = ContentScale.Crop,
                painter = painterResource(topicInfo.image),
                modifier = Modifier
                    .size(68.dp)
            )

            Column(
                modifier = Modifier
                    .padding(
                        bottom = 8.dp,
                        end = 16.dp,
                        start = 16.dp,
                        top = 16.dp
                    )
            ) {
                Text(name)
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        contentDescription = null,
                        painter = painterResource(R.drawable.build_1_grid_ic_grain),
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Text(
                        style = MaterialTheme.typography.labelMedium,
                        text = topicInfo.numberOfCourses.toString(),
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun TopicsGrid(
    topics: List<TopicInfo>
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(
            8.dp
        ),
        columns = GridCells.Adaptive(
            minSize = 200.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(
            8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(
            8.dp
        ),
    ) {
        items(
            items = topics,
            key = { it.id }
        ) { topicInfo ->
            TopicInfoCard(
                topicInfo = topicInfo
            )
        }
    }
}

// endregion

// region Preview

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun Build1GridScreenPreview() {
    Preview {
        Build1GridScreen()
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 960,
    showBackground = true,
    widthDp = 432
)
@Composable
private fun Build1GridScreenDarkPreview() {
    PreviewDark {
        Build1GridScreen()
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    heightDp = 601,
    showBackground = true,
    widthDp = 962
)
@Composable
private fun Build1GridScreenTabletPreview() {
    Preview {
        Build1GridScreen()
    }
}

// endregion
