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

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object KakaoColors {

    // Primary Color
    val blue600 = Color(0xFF096AE8)

    // Grey Color
    val grey900 = Color(0xFF282C37)
    val grey800 = Color(0xFF414747)
    val grey700 = Color(0xFF626871)
    val grey600 = Color(0xFF777777)
    val grey500 = Color(0xFF9D9D9D)
    val grey400 = Color(0xFF93969D)
    val grey300 = Color(0xFFD9D9D9)
    val grey200 = Color(0xFFDCDDDF)
    val grey150 = Color(0xFFE6E7E9)
    val grey100 = Color(0xFFF1F1F1)
    val grey50 = Color(0xFFF8F8F8)

    // Sub Color
    val subRed500 = Color(0xFFD02020)
    val subRed700 = Color(0xFF90292C)

    val subYellow500 = Color(0xFFFFE826)
    val subYellow700 = Color(0xFFEDBC00)

    // Static Color
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)

//    val all = listOf(
//        grey900, grey800, grey700,
//        grey600, grey500, grey400,
//        grey300, grey200, grey150,
//        grey100, grey50, blue600,
//        subRed500, subRed700,
//        subYellow500, subYellow700,
//        white, black )
}


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
