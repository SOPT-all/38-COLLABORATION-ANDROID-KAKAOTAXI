package com.jm.kakaotaxi.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.tooling.preview.Preview



object KakaoTheme {
    val colors: KakaoColors
        @Composable
        @ReadOnlyComposable
        get() = localKakaoColors.current
    val typography: KakaoTypography
        @Composable
        @ReadOnlyComposable
        get() = localKakaoTypography.current
}

@Composable
fun ProvideKakaoColorsAndTypography(
    colors: KakaoColors,
    typography: KakaoTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        localKakaoColors provides colors,
        localKakaoTypography provides typography,
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