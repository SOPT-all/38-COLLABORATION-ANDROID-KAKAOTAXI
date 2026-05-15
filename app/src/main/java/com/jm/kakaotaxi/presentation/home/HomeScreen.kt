package com.jm.kakaotaxi.presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.jm.kakaotaxi.presentation.home.component.EventNoticeSection
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

                Spacer(modifier = Modifier.height(15.dp))

                QuickPlaceList(places = quickPlaces)

                Spacer(modifier = Modifier.height(15.dp))

                FavoriteSection(
                    services = services,
                    onStarClick = onStarClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }

        item{
            Spacer(modifier = Modifier.height(15.dp))

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 10.dp,
                color = KakaotaxiTheme.colors.backgroundGray2
            )

            Spacer(modifier = Modifier.height(15.dp))
        }

        item{EventNoticeSection(modifier = Modifier.fillMaxWidth())}
    }
}


@Preview(showBackground = true, heightDp = 1195)
@Composable
private fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeRoute()
    }
}
