package com.example.lab0.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lab0.R

val Nunito_Font = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_light, FontWeight.Light)
)

val Typography = Typography(
    displayLarge = TextStyle( fontFamily = Nunito_Font ),
    displayMedium = TextStyle( fontFamily = Nunito_Font ),
    displaySmall = TextStyle( fontFamily = Nunito_Font ),
    headlineLarge = TextStyle( fontFamily = Nunito_Font ),
    headlineMedium = TextStyle( fontFamily = Nunito_Font ),
    headlineSmall = TextStyle( fontFamily = Nunito_Font ),
    titleLarge = TextStyle( fontFamily = Nunito_Font ),
    titleMedium = TextStyle( fontFamily = Nunito_Font ),
    titleSmall = TextStyle( fontFamily = Nunito_Font ),
    bodyLarge = TextStyle( fontFamily = Nunito_Font ),
    bodyMedium = TextStyle( fontFamily = Nunito_Font ),
    bodySmall = TextStyle( fontFamily = Nunito_Font ),
    labelLarge = TextStyle( fontFamily = Nunito_Font ),
    labelMedium = TextStyle( fontFamily = Nunito_Font ),
    labelSmall = TextStyle( fontFamily = Nunito_Font ),
)