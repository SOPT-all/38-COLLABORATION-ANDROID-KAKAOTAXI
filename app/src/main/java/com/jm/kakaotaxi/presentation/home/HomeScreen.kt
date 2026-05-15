package com.jm.kakaotaxi.presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
        onStarClick = { model -> viewModel.onStarClick(model) },
        modifier = modifier.fillMaxSize()
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
    LazyColumn(
        modifier = modifier
            .background(KakaotaxiTheme.colors.white)
    ){
        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.5.dp)
                    .padding(top = 25.dp)
            ){
                KakaoTaxiSearchBar(
                    type = SearchBarType.HOME,
                    onSearchBarClick = onSearchBarClick
                )

                QuickPlaceList(
                    places = quickPlaces,
                    modifier = Modifier.padding(vertical = 15.dp)
                )

                FavoriteSection(
                    services = services,
                    onStarClick = onStarClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }

        item{
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                thickness = 10.dp,
                color = KakaotaxiTheme.colors.backgroundGray2
            )
        }

        item{EventSection()}

        item{
            HorizontalDivider(
                modifier = Modifier,
                thickness = 1.dp,
                color = KakaotaxiTheme.colors.backgroundGray
            )
        }

        item{NoticeSection()}
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeRoute()
    }
}
