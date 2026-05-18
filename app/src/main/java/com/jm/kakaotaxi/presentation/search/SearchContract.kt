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
    )
}
