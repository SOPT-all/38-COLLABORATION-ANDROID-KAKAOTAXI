package com.jm.kakaotaxi.presentation.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiSearchBar
import com.jm.kakaotaxi.core.designsystem.component.quickplace.QuickPlaceList
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.type.SearchBarType
import com.jm.kakaotaxi.data.model.FavoriteServiceModel
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.presentation.home.component.FavoriteServiceGrid
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
    ){
        KakaoTaxiSearchBar(
            type = SearchBarType.HOME,
            onSearchBarClick = onSearchBarClick
        )

        QuickPlaceList(places = quickPlaces)

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "자주 쓰는 서비스",
                color = KakaotaxiTheme.colors.textPrimary,
                style = KakaotaxiTheme.typography.body.kakaoB16
            )

            Text(
                text = "편집",
                color = KakaotaxiTheme.colors.textSecondary,
                style = KakaotaxiTheme.typography.body.kakaoB14
            )
        }

        Image(
            painter = painterResource(R.drawable.img_home_point_taxi),
            contentDescription = null,
            modifier = Modifier
        )

        FavoriteServiceGrid(
            services = services,
            onStarClick = onStarClick
        )

        Text(
            text = "전체 서비스 보기",
            color = KakaotaxiTheme.colors.textSecondary,
            textAlign = TextAlign.Center,
            style = KakaotaxiTheme.typography.body.kakaoB16,
        )

        HorizontalDivider(
            modifier = Modifier,
            thickness = 10.dp,
            color = KakaotaxiTheme.colors.backgroundGray2
        )

        Text(
            text = "이벤트/새소식",
            color = KakaotaxiTheme.colors.textPrimary,
            style = KakaotaxiTheme.typography.body.kakaoB16
        )

        Image(
            painter = painterResource(R.drawable.img_home_event_banner),
            contentDescription = null,
            modifier = Modifier
        )

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
