package com.jm.kakaotaxi.presentation.call

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.search.SearchScreen

@Composable
fun CallRoute(
    modifier: Modifier = Modifier
) {
    CallScreen(
        modifier = modifier
    )
}

@Composable
fun CallScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun CallScreenPreview() {
    KakaotaxiTheme {
        CallScreen()
    }
}
