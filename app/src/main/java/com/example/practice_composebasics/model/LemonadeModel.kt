package com.example.practice_composebasics.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practice_composebasics.R

internal sealed class Screen(
    @StringRes val contentDescription: Int,
    @DrawableRes val image: Int,
    @StringRes val title: Int,
) {
    object Screen1LemonTree : Screen(
        contentDescription = R.string.lemonade_screen_tap_to_select_image_content_description,
        image = R.drawable.lemon_tree,
        title = R.string.lemonade_screen_tap_to_select
    )

    class Screen2Lemon(
        val timesNeeded: Int = (2..8).random()
    ) : Screen(
        contentDescription = R.string.lemonade_screen_keep_tapping_image_content_description,
        image = R.drawable.lemon_squeeze,
        title = R.string.lemonade_screen_keep_tapping
    )

    object Screen3GlassOfLemonade : Screen(
        contentDescription = R.string.lemonade_screen_tap_to_drink_image_content_description,
        image = R.drawable.lemon_drink,
        title = R.string.lemonade_screen_tap_to_drink
    )

    object Screen4EmptyGlass : Screen(
        contentDescription = R.string.lemonade_screen_restart_image_content_description,
        image = R.drawable.lemon_restart,
        title = R.string.lemonade_screen_restart
    )
}
