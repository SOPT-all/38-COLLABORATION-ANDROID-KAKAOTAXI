package com.jm.kakaotaxi.presentation.search

import androidx.lifecycle.ViewModel
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.core.designsystem.theme.KakaotaxiTheme
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.data.model.search.SearchHistoryModel
import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import com.jm.kakaotaxi.presentation.search.type.SearchHistoryType
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SearchContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        getMyPlaces()
        getRecentPlaces()
        getHistoryItems()
    }

    private fun getMyPlaces() {
        _uiState.update {
            // api 연동
            it.copy(
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
                )
            )
        }
    }

    private fun getRecentPlaces() {
        _uiState.update {
            // api 연동
            it.copy(
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
                )
            )
        }
    }

    private fun getHistoryItems() {
        _uiState.update {
            it.copy(
                historyItems =
                    persistentListOf(
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
                    )
            )
        }
    }
}
