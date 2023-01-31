package com.example.practice_composebasics.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.practice_composebasics.R

val Cabin = FontFamily(
    Font(R.font.font_cabin_regular, FontWeight.Normal),
    Font(R.font.font_cabin_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = Cabin,
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    ),
    displaySmall = TextStyle(
        fontFamily = Cabin,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        fontFamily = Cabin,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start
    ),
    titleSmall = TextStyle(
        fontFamily = Cabin,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start
    ),
    bodyMedium = TextStyle(
        fontFamily = Cabin,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Justify
    )
)
