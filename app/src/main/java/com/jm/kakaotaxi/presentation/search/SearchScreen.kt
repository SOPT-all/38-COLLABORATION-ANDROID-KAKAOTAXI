package com.jm.kakaotaxi.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.presentation.home.HomeScreen

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier
) {
    SearchScreen(
        modifier = modifier
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {

}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    KakaotaxiTheme {
        SearchScreen()
    }
}
