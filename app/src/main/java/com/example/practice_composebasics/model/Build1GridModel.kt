package com.example.practice_composebasics.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string

data class TopicInfo(
    val id: Int,
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    val numberOfCourses: Int
)

object Build1GridDataSource {
    val topics = listOf(
        TopicInfo(
            id = 1,
            image = drawable.build_1_grid_architecture,
            name = string.build_1_grid_architecture,
            numberOfCourses = 58
        ),
        TopicInfo(
            id = 2,
            image = drawable.build_1_grid_crafts,
            name = string.build_1_grid_crafts,
            numberOfCourses = 121
        ),
        TopicInfo(
            id = 3,
            image = drawable.build_1_grid_business,
            name = string.build_1_grid_business,
            numberOfCourses = 78
        ),
        TopicInfo(
            id = 4,
            image = drawable.build_1_grid_culinary,
            name = string.build_1_grid_culinary,
            numberOfCourses = 118
        ),
        TopicInfo(
            id = 5,
            image = drawable.build_1_grid_design,
            name = string.build_1_grid_design,
            numberOfCourses = 423
        ),
        TopicInfo(
            id = 6,
            image = drawable.build_1_grid_fashion,
            name = string.build_1_grid_fashion,
            numberOfCourses = 92
        ),
        TopicInfo(
            id = 7,
            image = drawable.build_1_grid_film,
            name = string.build_1_grid_film,
            numberOfCourses = 165
        ),
        TopicInfo(
            id = 8,
            image = drawable.build_1_grid_gaming,
            name = string.build_1_grid_gaming,
            numberOfCourses = 164
        ),
        TopicInfo(
            id = 9,
            image = drawable.build_1_grid_drawing,
            name = string.build_1_grid_drawing,
            numberOfCourses = 326
        ),
        TopicInfo(
            id = 10,
            image = drawable.build_1_grid_lifestyle,
            name = string.build_1_grid_lifestyle,
            numberOfCourses = 305
        ),
        TopicInfo(
            id = 11,
            image = drawable.build_1_grid_music,
            name = string.build_1_grid_music,
            numberOfCourses = 212
        ),
        TopicInfo(
            id = 12,
            image = drawable.build_1_grid_painting,
            name = string.build_1_grid_painting,
            numberOfCourses = 172
        ),
        TopicInfo(
            id = 13,
            image = drawable.build_1_grid_photography,
            name = string.build_1_grid_photography,
            numberOfCourses = 321
        ),
        TopicInfo(
            id = 14,
            image = drawable.build_1_grid_tech,
            name = string.build_1_grid_tech,
            numberOfCourses = 118
        ),
        TopicInfo(
            id = 15,
            image = drawable.build_1_grid_tech,
            name = string.build_1_grid_tech,
            numberOfCourses = 155
        )
    )
}
