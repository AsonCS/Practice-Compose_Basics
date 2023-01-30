package com.example.practice_composebasics.model

import androidx.annotation.DrawableRes
import com.example.practice_composebasics.R

internal open class WebbTelescopeImage(
    @DrawableRes val fallbackImage: Int = R.drawable.ic_launcher_foreground,
    val image: String,
    val releaseDate: String,
    val source: String,
    val title: String
)

private object CosmicCliffsDefault : WebbTelescopeImage(
    fallbackImage = R.drawable.image_cosmic_cliffs,
    image = "",
    releaseDate = "July 12, 2022 11:22AM (EDT)",
    source = "https://webbtelescope.org/contents/media/images/2022/031/01G77PKB8NKR7S8Z6HBXMYATGJ",
    title = "Default \"Cosmic Cliffs\"",
)

private object CosmicCliffs : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_cosmic_cliffs.png",
    releaseDate = "July 12, 2022 11:22AM (EDT)",
    source = "https://webbtelescope.org/contents/media/images/2022/031/01G77PKB8NKR7S8Z6HBXMYATGJ",
    title = "\"Cosmic Cliffs\" in the Carina Nebula (NIRCam Image)",
)

private object CosmicCliffsComposite : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_cosmic_cliffs_composite.png",
    releaseDate = "July 12, 2022 11:22AM (EDT)",
    source = "https://webbtelescope.org/contents/media/images/2022/031/01G780WF1VRADDSD5MDNDRKAGY",
    title = "\"Cosmic Cliffs\" in the Carina Nebula (NIRCam and MIRI Composite Image)",
)

private object FirstDeepField : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_first_deep_field.png",
    releaseDate = "July 12, 2022 10:39AM (EDT)",
    source = "https://webbtelescope.org/contents/media/images/2022/035/01G7DCWB7137MYJ05CSH1Q5Z1Z",
    title = "Webb's First Deep Field (NIRCam Image)",
)

private object StephanQuintet : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_stephan_quintet.png",
    releaseDate = "July 12, 2022 11:13AM (EDT)",
    source = "https://webbtelescope.org/contents/media/images/2022/034/01G7DA5ADA2WDSK1JJPQ0PTG4A",
    title = "Stephan's Quintet (NIRCam and MIRI Composite Image)",
)

private object ExoplanetLHS475 : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_exoplanet_lhs_475.png",
    releaseDate = "January 11, 2023 1:15PM (EST)",
    source = "https://webbtelescope.org/contents/media/images/2023/102/01GNVTTACCM2GA5P3B6S5EAMWD",
    title = "Exoplanet LHS 475 b and Its Star (Illustration)",
)

private object SouthernRingNebula : WebbTelescopeImage(
    image = "https://raw.githubusercontent.com/AsonCS/Practice-Compose_Basics/master/images/image_southern_ring_nebula.png",
    releaseDate = "January 23, 2023 11:00AM (EST)",
    source = "https://webbtelescope.org/contents/media/images/2023/106/01GQ2TJ92FQK45MY7JEYKWS834",
    title = "Chamaeleon I Molecular Cloud (NIRCam Image)",
)

internal val webbTelescopeImageList = listOf(
    CosmicCliffsDefault,
    CosmicCliffs,
    CosmicCliffsComposite,
    FirstDeepField,
    StephanQuintet,
    ExoplanetLHS475,
    SouthernRingNebula
)

internal val imageListSize = webbTelescopeImageList.size - 1
