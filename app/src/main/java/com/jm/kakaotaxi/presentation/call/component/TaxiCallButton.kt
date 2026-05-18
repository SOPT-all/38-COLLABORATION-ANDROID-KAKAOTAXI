package com.jm.kakaotaxi.presentation.call.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.component.ButtonStyle
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun TaxiCallButton(
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    ButtonItem(
        text = "택시 부르기",
        style = ButtonStyle.CALL,
        onClick = {},
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun TaxiCallButtonPreview() {
    KakaotaxiTheme {
        TaxiCallButton(
            onClick = {}
        )
    }
}
