package com.jm.kakaotaxi.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme

@Composable
fun KakaoTaxiCircularProgressIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(vertical = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = KakaotaxiTheme.colors.backgroundGray
        )
    }
}

@Preview
@Composable
private fun KakaoTaxiCircularProgressIndicatorPreview() {
    KakaotaxiTheme {
        KakaoTaxiCircularProgressIndicator()
    }
}
