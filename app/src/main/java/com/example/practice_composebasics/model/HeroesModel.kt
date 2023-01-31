package com.example.practice_composebasics.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practice_composebasics.R.drawable
import com.example.practice_composebasics.R.string

data class Hero(
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    @StringRes val name: Int,
)

object HeroesRepository {
    val heroes = listOf(
        Hero(
            description = string.heroes_screen_hero_description_1,
            image = drawable.android_superhero1,
            name = string.heroes_screen_hero_name_1
        ),
        Hero(
            description = string.heroes_screen_hero_description_2,
            image = drawable.android_superhero2,
            name = string.heroes_screen_hero_name_2
        ),
        Hero(
            description = string.heroes_screen_hero_description_3,
            image = drawable.android_superhero3,
            name = string.heroes_screen_hero_name_3
        ),
        Hero(
            description = string.heroes_screen_hero_description_4,
            image = drawable.android_superhero4,
            name = string.heroes_screen_hero_name_4
        ),
        Hero(
            description = string.heroes_screen_hero_description_5,
            image = drawable.android_superhero5,
            name = string.heroes_screen_hero_name_5
        ),
        Hero(
            description = string.heroes_screen_hero_description_6,
            image = drawable.android_superhero6,
            name = string.heroes_screen_hero_name_6
        )
    )
}
