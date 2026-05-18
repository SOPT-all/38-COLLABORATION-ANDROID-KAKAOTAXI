package com.jm.kakaotaxi.presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiSearchBar
import com.jm.kakaotaxi.core.designsystem.component.quickplace.QuickPlaceList
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.type.SearchBarType
import com.jm.kakaotaxi.data.model.home.FavoriteServiceModel
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.presentation.home.component.EventNoticeSection
import com.jm.kakaotaxi.presentation.home.component.FavoriteSection
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeRoute(
    navigateToSearch: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        quickPlaces = uiState.myPlaces,
        favoriteServices = uiState.favoritePlaces,
        onSearchBarClick = viewModel::onSearchBarClick,
        onStarClick = viewModel::onStarClick,
        onServiceClick = navigateToSearch,
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    quickPlaces: ImmutableList<QuickPlaceModel>,
    favoriteServices: ImmutableList<FavoriteServiceModel>,
    onSearchBarClick: () -> Unit,
    onStarClick: (Int) -> Unit,
    onServiceClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .background(KakaotaxiTheme.colors.white)
    ){
        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ){
                KakaoTaxiSearchBar(
                    type = SearchBarType.HOME,
                    onSearchBarClick = onSearchBarClick
                )

                Spacer(modifier = Modifier.height(15.dp))

                QuickPlaceList(places = quickPlaces)

                FavoriteSection(
                    services = favoriteServices,
                    onStarClick = onStarClick,
                    onServiceClick = onServiceClick
                )
            }
        }

        item{
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 10.dp,
                color = KakaotaxiTheme.colors.backgroundGray2
            )
        }

        item{
            EventNoticeSection(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    KakaotaxiTheme {
        HomeRoute()
    }
}
