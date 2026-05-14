package com.jm.kakaotaxi.presentation.call

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.component.ButtonItem
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun TaxiCallButton(
    modifier: Modifier = Modifier
) {
    ButtonItem(
        modifier = modifier.padding(horizontal = 19.dp),
        text = "택시 부르기",
        backgroundColor = KakaotaxiTheme.colors.primaryBlue,
        contentColor = KakaotaxiTheme.colors.white,
        paddingValues = PaddingValues(
            horizontal = 117.75.dp,
            vertical = 12.5.dp
        ),
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TaxiCallButtonPreview() {
    KakaotaxiTheme {
        TaxiCallButton()
    }
}
