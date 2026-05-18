package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.ui.graphics.Color

enum class ButtonStyle(
    val backgroundColor: Color,
    val borderColor: Color,
    val textColor: Color
) {
    CALL(
        backgroundColor = Color(0xFF076AEB),
        borderColor = Color.Transparent,
        textColor = Color.White
    ),

    NO(
        backgroundColor = Color.White,
        borderColor = Color(0xFFEDEDED),
        textColor = Color(0xFF93969D)
    ),

    YES(
        backgroundColor = Color(0xFF076AEB),
        borderColor = Color.Transparent,
        textColor = Color.White
    ),

    SHARE(
        backgroundColor = Color.White,
        borderColor = Color(0xFFEDEDED),
        textColor = Color(0xFF626871)
    )
}
