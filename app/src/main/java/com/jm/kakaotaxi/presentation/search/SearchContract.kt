package com.jm.kakaotaxi.presentation.search

import com.jm.kakaotaxi.data.model.QuickPlaceModel
import com.jm.kakaotaxi.data.model.search.SearchHistoryModel
import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface SearchContract {
    data class State(
        val myPlaces: ImmutableList<QuickPlaceModel> = persistentListOf(),
        val recentPlaces: ImmutableList<SearchRecentModel> = persistentListOf(),
        val historyItems: ImmutableList<SearchHistoryModel> = persistentListOf(),
        val recentPlacesUiState: RecentPlacesUiState = RecentPlacesUiState.Idle,
    )
}

sealed interface RecentPlacesUiState {
    data object Idle : RecentPlacesUiState

    data object Loading : RecentPlacesUiState

    data object Empty : RecentPlacesUiState

    data object Success : RecentPlacesUiState

    data class Failure(
        val msg: String,
    ) : RecentPlacesUiState
}

