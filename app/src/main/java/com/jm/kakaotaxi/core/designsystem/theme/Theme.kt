package com.jm.kakaotaxi.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


object KakaoTheme {
    val colors: KakaoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoColors.current
    val typography: KakaoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoTypography.current
}

@Composable
fun ProvideKakaoColorsAndTypography(
    colors: KakaoColors,
    typography: KakaoTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalKakaoColors provides colors,
        LocalKakaoTypography provides typography,
        content = content,
    )
}

@Composable
fun KakaotaxiTheme(
    content: @Composable () -> Unit,
) {
    ProvideKakaoColorsAndTypography(
        colors = defaultKakaoColors,
        typography = defaultKakaoTypography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}