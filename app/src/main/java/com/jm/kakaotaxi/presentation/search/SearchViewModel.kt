package com.jm.kakaotaxi.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jm.kakaotaxi.R
import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.data.model.search.SearchHistoryModel
import com.jm.kakaotaxi.data.repository.api.PlaceRepository
import com.jm.kakaotaxi.presentation.search.type.SearchHistoryType
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val placeRepository: PlaceRepository,
) : ViewModel() {

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

    private fun getRecentPlaces() = viewModelScope.launch {
        _uiState.update { it.copy(recentPlacesUiState = RecentPlacesUiState.Loading) }

        placeRepository.getRecentPlaces()
            .onSuccess { recentPlaces ->
                _uiState.update {
                    it.copy(
                        recentPlaces = recentPlaces.toImmutableList(),
                        recentPlacesUiState = RecentPlacesUiState.Success
                    )
                }
            }
            .onFailure { error ->
                _uiState.update {
                    it.copy(
                        recentPlacesUiState = RecentPlacesUiState.Failure(error.message ?: "Unknown Error"),
                    )
                }
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
