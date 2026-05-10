package com.jm.kakaotaxi.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.theme.Typography

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeScreen()
    }
}
