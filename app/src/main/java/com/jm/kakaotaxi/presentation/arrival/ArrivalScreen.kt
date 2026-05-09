package com.jm.kakaotaxi.presentation.arrival

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.call.CallScreen

@Composable
fun ArrivalRoute(
    modifier: Modifier = Modifier
) {
    ArrivalScreen(
        modifier = modifier
    )
}

@Composable
fun ArrivalScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun ArrivalScreenPreview() {
    KakaotaxiTheme {
        ArrivalScreen()
    }
}
