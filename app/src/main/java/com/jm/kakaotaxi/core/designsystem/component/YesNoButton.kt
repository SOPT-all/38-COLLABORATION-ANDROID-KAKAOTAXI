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

@Composable
fun AnswerButton(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(horizontal = 21.dp))
    {
        ButtonItem(
            text = "아니요",
            backgroundColor = KakaotaxiTheme.colors.white,
            contentColor = KakaotaxiTheme.colors.subGray,
            paddingValues = PaddingValues(
                horizontal = 52.dp,
                vertical = 10.dp
            ),
            modifier = Modifier.border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(10.dp)
            ),
            onClick = {}
        )

        Spacer(modifier = Modifier.width(10.dp))

        ButtonItem(
            text = "네",
            backgroundColor = KakaotaxiTheme.colors.primaryBlue,
            contentColor = KakaotaxiTheme.colors.white,
            paddingValues = PaddingValues(
                horizontal = 68.5.dp,
                vertical = 10.dp
            ),
            modifier = Modifier.background(
                color = KakaotaxiTheme.colors.primaryBlue,
                shape = RoundedCornerShape(10.dp)
            ),
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