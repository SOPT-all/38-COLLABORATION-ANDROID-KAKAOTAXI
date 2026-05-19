package com.jm.kakaotaxi.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.component.KakaoTaxiSearchBar
import com.jm.kakaotaxi.core.designsystem.component.quickplace.QuickPlaceList
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.core.designsystem.type.SearchBarType
import com.jm.kakaotaxi.core.di.ViewModelFactory
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.data.model.search.SearchHistoryModel
import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import com.jm.kakaotaxi.presentation.search.component.SearchAdBannerSection
import com.jm.kakaotaxi.presentation.search.component.SearchHistoryItem
import com.jm.kakaotaxi.presentation.search.component.SearchRecentItem
import com.jm.kakaotaxi.presentation.search.component.SearchTitleSection
import com.jm.kakaotaxi.presentation.search.type.SearchHistoryType
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun SearchRoute(
    navigateToCall: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(factory = ViewModelFactory()),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SearchScreen(
        myPlaces = uiState.myPlaces,
        recentPlaces = uiState.recentPlaces,
        historyItems = uiState.historyItems,
        onRecentItemClick = navigateToCall,
        modifier = modifier,
    )
}

@Composable
private fun SearchScreen(
    myPlaces: ImmutableList<QuickPlaceModel>,
    recentPlaces: ImmutableList<SearchRecentModel>,
    historyItems: ImmutableList<SearchHistoryModel>,
    onRecentItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(
                color = KakaotaxiTheme.colors.white,
            )
            .padding(top = 20.dp, bottom = 30.dp)
    ) {
        KakaoTaxiSearchBar(
            type = SearchBarType.SEARCH,
            onSearchBarClick = {},
            modifier = Modifier.padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(25.dp))

        QuickPlaceList(
            places = myPlaces,
            modifier = Modifier.padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(18.dp))

        SearchTitleSection(
            title = "최근에 간 곳",
            subtitle = "눌러서 바로 택시를 부를 수 있어요",
            modifier = Modifier.padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            recentPlaces.chunked(2).forEach { places ->
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                ) {
                    places.forEach { place ->
                        SearchRecentItem(
                            place = place.place,
                            time = place.time,
                            location = place.location,
                            onRecentItemClick = onRecentItemClick,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            thickness = 10.dp,
            color = KakaotaxiTheme.colors.backgroundGray,
        )

        Spacer(modifier = Modifier.height(21.dp))

        SearchAdBannerSection(
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(35.dp))

        HorizontalDivider(
            thickness = 10.dp,
            color = KakaotaxiTheme.colors.backgroundGray
        )

        Spacer(modifier = Modifier.height(15.dp))

        SearchTitleSection(
            title = "검색한 곳",
            subtitle = "이전에 찾아보신 장소예요",
            modifier = Modifier.padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(21.dp),
            modifier = Modifier.padding(horizontal = 24.dp),
        ) {
            historyItems.forEach { item ->
                SearchHistoryItem(
                    type = item.type,
                    place = item.place,
                    address = item.address,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    KakaotaxiTheme {
        SearchScreen(
            myPlaces = persistentListOf(
                QuickPlaceModel(
                    id = 1,
                    title = "집",
                    icon = R.drawable.ic_home,
                ),
                QuickPlaceModel(
                    id = 2,
                    title = "한사랑병원",
                    icon = R.drawable.ic_hospital,
                ),
                QuickPlaceModel(
                    id = 3,
                    title = "노인정",
                    icon = R.drawable.ic_senior_home,
                )
            ),
            recentPlaces = persistentListOf(
                SearchRecentModel(
                    id = 1,
                    place = "한사랑병원",
                    time = "오늘 오전",
                    location = "송파구"
                ),
                SearchRecentModel(
                    id = 2,
                    place = "강남구 보건소",
                    time = "오늘 오후",
                    location = "강남구"
                ),
                SearchRecentModel(
                    id = 3,
                    place = "성동복지관",
                    time = "어제",
                    location = "성동구"
                ),
                SearchRecentModel(
                    id = 4,
                    place = "탑마트 성수점",
                    time = "어제",
                    location = "성동구"
                ),
            ),
            historyItems = persistentListOf(
                SearchHistoryModel(
                    type = SearchHistoryType.MAP,
                    place = "한사랑병원 응급실",
                    address = "서울 송파구 올림픽로 43길 88"
                ),
                SearchHistoryModel(
                    type = SearchHistoryType.DIRECT,
                    place = "근처 약국",
                    address = "직접 검색하셨어요."
                ),
                SearchHistoryModel(
                    type = SearchHistoryType.MAP,
                    place = "성동노인종합복지관",
                    address = "서울 성동구 왕십리로 157"
                ),
            ),
            onRecentItemClick = {},
        )
    }
}
