package com.jm.kakaotaxi.presentation.arrival

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun ShareClickButton(
    modifier: Modifier = Modifier
) {
    ButtonItem(
        modifier = modifier
            .padding(horizontal = 21.dp)
            .border(
                width = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray,
                shape = RoundedCornerShape(10.dp)
            ),
        text = "보호자에게 공유",
        backgroundColor = KakaotaxiTheme.colors.white,
        contentColor = KakaotaxiTheme.colors.textSecondary,
        paddingValues = PaddingValues(
            horizontal = 99.dp,
            vertical = 12.5.dp
        ),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ShareClickButtonPreview() {
    KakaotaxiTheme {
        ShareClickButton()
    }
}