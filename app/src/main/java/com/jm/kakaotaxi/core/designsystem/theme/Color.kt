package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Immutable
data class KakaoColors (
    // Primary Color
    val primaryBlue: Color,

    // Gray Color
    val textPrimary: Color,
    val textSecondary: Color,
    val subGray: Color,
    val subGray2: Color,
    val backgroundGray: Color,
    val backgroundGray2: Color,

    // Sub Color
    val pointYellow: Color,
    val softYellow: Color,

    // Static Color
    val white: Color,
    val black: Color
)

val defaultKakaoColors = KakaoColors(
    // Primary Color
    primaryBlue = Color(0xFF076AEB),

    // Gray Color
    textPrimary = Color(0xFF282C37),
    textSecondary = Color(0xFF626871),
    subGray = Color(0xFF93969D),
    subGray2 = Color(0xFFB9BBBF),
    backgroundGray = Color(0xFFEDEDED),
    backgroundGray2 = Color(0xFFF4F6F7),

    // Sub Color
    pointYellow = Color(0xFFFFD213),
    softYellow = Color(0xFFFFF3BF),

    // Static Color
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000)
)

val LocalKakaoColors = staticCompositionLocalOf { defaultKakaoColors }

@Preview(showBackground = true)
@Composable
private fun KakaoColorsPreview() {
    KakaotaxiTheme {
        Column {
            listOf(
                // Primary Color
                KakaotaxiTheme.colors.primaryBlue,

                // Gray Color
                KakaotaxiTheme.colors.textPrimary,
                KakaotaxiTheme.colors.textSecondary,
                KakaotaxiTheme.colors.subGray,
                KakaotaxiTheme.colors.subGray2,
                KakaotaxiTheme.colors.backgroundGray,
                KakaotaxiTheme.colors.backgroundGray2,

                // Sub Color
                KakaotaxiTheme.colors.pointYellow,
                KakaotaxiTheme.colors.softYellow,

                // Static Color
                KakaotaxiTheme.colors.white,
                KakaotaxiTheme.colors.black,

            ).chunked(6).forEach { rowColors ->
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    rowColors.forEach { c ->
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(c)
                                .padding(end = 8.dp),
                        )
                    }
                }
            }
        }
    }
}