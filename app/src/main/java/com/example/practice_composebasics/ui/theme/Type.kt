package com.example.practice_composebasics.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Justify
    )
)
