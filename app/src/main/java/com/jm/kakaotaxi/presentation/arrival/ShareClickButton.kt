package com.jm.kakaotaxi.presentation.arrival

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.component.ButtonStyle
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun ShareClickButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit
) {
    ButtonItem(
        text = "보호자에게 공유",
        style = ButtonStyle.SHARE,
        onClick = {},
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun ShareClickButtonPreview() {
    KakaotaxiTheme {
        ShareClickButton(
            onClick = {}
        )
    }
}