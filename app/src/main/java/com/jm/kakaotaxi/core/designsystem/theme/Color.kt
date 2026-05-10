package com.jm.kakaotaxi.core.designsystem.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Immutable
data class KakaoColors (
    // Main Color
    val textPrimary: Color,
    val textSecondary: Color,
    val bluePrimary: Color,

    // Primary Color
    val blue600: Color,

    // Grey Color
    val grey900: Color,
    val grey800: Color,
    val grey700: Color,
    val grey600: Color,
    val grey500: Color,
    val grey400: Color,
    val grey300: Color,
    val grey200: Color,
    val grey150: Color,
    val grey100: Color,
    val grey50: Color,

    // Sub Color
    val subRed500: Color,
    val subRed700: Color,
    val subYellow500: Color,
    val subYellow700: Color,

    // Static Color
    val white: Color,
    val black: Color
)

val defaultKakaoColors = KakaoColors(
    // Main Color
    textPrimary = Color(0xFF282C37),
    textSecondary = Color(0xFF626871),
    bluePrimary = Color(0xFF096AE8),

    // Primary Color
    blue600 = Color(0xFF096AE8),

    // Grey Color
    grey900 = Color(0xFF282C37),
    grey800 = Color(0xFF414747),
    grey700 = Color(0xFF626871),
    grey600 = Color(0xFF777777),
    grey500 = Color(0xFF9D9D9D),
    grey400 = Color(0xFF93969D),
    grey300 = Color(0xFFD9D9D9),
    grey200 = Color(0xFFDCDDDF),
    grey150 = Color(0xFFE6E7E9),
    grey100 = Color(0xFFF1F1F1),
    grey50 = Color(0xFFF8F8F8),

    // Sub Color
    subRed500 = Color(0xFFD02020),
    subRed700 = Color(0xFF90292C),
    subYellow500 = Color(0xFFFFE826),
    subYellow700 = Color(0xFFEDBC00),

    // Static Color
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000),
)

val localKakaoColors = staticCompositionLocalOf { defaultKakaoColors }

//@Preview
//@Composable
//fun ColorPreview() {
//    Column(modifier = Modifier.padding(8.dp)) {
//        KakaoColors.all
//            .chunked(6)
//            .forEach { rowColors ->
//            Row(modifier = Modifier.padding(vertical = 4.dp)) {
//                rowColors.forEach { color ->
//                    Box(
//                        modifier = Modifier
//                            .size(24.dp)
//                            .padding(end = 8.dp)
//                            .background(color)
//                    )
//                }
//            }
//        }
//    }
//}
