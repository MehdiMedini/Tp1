package com.example.rayna.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = RoyalAmethyst,
    secondary = CoralBlush,
    tertiary = OceanTeal,
    background = CloudWhite,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = MidnightInk,
    onSurface = MidnightInk.copy(alpha = 0.8f),
    error = AlertRuby,
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = DeepLavender,
    secondary = SunsetCoral,
    tertiary = AbyssalTeal,
    background = MidnightInk,
    surface = Color(0xFF2A2A2A),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = CloudWhite,
    onSurface = CloudWhite.copy(alpha = 0.8f),
    error = AlertRuby,
    onError = Color.White
)

@Composable
fun RaynaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    // Choose color scheme based on theme mode
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}