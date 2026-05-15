package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.main.component.BottomNavType

@Composable
fun AnswerButton(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier)
    {
        ButtonItem(
            text = "아니요",
            style = ButtonStyle.NO,
            horizontalPadding = 52.dp,
            onClick = {}
        )

        Spacer(modifier = Modifier.width(10.dp))

        ButtonItem(
            text = "네",
            style = ButtonStyle.YES,
            horizontalPadding = 69.dp,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnswerButtonPreview() {
    KakaotaxiTheme {
        AnswerButton()
    }
}