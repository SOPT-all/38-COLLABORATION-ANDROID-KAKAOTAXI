package com.jm.kakaotaxi.presentation.home


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiSearchBar
import com.jm.kakaotaxi.core.designsystem.component.quickplace.QuickPlaceList
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.type.SearchBarType
import com.jm.kakaotaxi.data.model.FavoriteServiceModel
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.presentation.home.component.EventSection
import com.jm.kakaotaxi.presentation.home.component.FavoriteSection
import com.jm.kakaotaxi.presentation.home.component.NoticeSection
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier
) {
    val viewModel: HomeViewModel = viewModel()

    HomeScreen(
        quickPlaces = viewModel.getHomeData(),
        services = viewModel.favoriteServices,
        onSearchBarClick = { viewModel.onSearchBarClick() },
        onStarClick = { model -> viewModel.onStarClick(model) }
    )
}

@Composable
private fun HomeScreen(
    quickPlaces: ImmutableList<QuickPlaceModel>,
    services: ImmutableList<FavoriteServiceModel>,
    onSearchBarClick: () -> Unit,
    onStarClick: (FavoriteServiceModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        KakaoTaxiSearchBar(
            type = SearchBarType.HOME,
            onSearchBarClick = onSearchBarClick
        )

        QuickPlaceList(places = quickPlaces)

        FavoriteSection(
            services = services,
            onStarClick = onStarClick
        )

        HorizontalDivider(
            modifier = Modifier,
            thickness = 10.dp,
            color = KakaotaxiTheme.colors.backgroundGray2
        )

        EventSection()

        HorizontalDivider(
            modifier = Modifier,
            thickness = 1.dp,
            color = KakaotaxiTheme.colors.backgroundGray
        )

        NoticeSection()
    }


}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeRoute()
    }
}
