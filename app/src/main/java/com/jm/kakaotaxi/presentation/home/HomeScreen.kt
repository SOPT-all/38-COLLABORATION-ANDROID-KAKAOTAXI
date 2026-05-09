package com.jm.kakaotaxi.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.main.Greeting

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeScreen()
    }
}
