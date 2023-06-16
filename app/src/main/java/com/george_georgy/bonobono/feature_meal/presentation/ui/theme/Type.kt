package com.george_georgy.bonobono.feature_meal.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.george_georgy.bonobono.R

// Set of Material typography styles to start with

val popinsFonts = FontFamily(
    fonts = listOf(
        Font(R.font.popins_regular, style = FontStyle.Normal),
        Font(R.font.poppins_medium, style = FontStyle.Normal, weight = FontWeight.Medium),
        Font(R.font.poppins_semibold, style = FontStyle.Normal, weight = FontWeight.SemiBold),

        )
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = popinsFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,

    ),
    bodySmall = TextStyle(
        fontFamily = popinsFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,

        ),
    headlineLarge = TextStyle(
        fontFamily = popinsFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,

    ),
    headlineMedium = TextStyle(
        fontFamily = popinsFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,

    ),
    headlineSmall = TextStyle(
        fontFamily = popinsFonts,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,

        )







)