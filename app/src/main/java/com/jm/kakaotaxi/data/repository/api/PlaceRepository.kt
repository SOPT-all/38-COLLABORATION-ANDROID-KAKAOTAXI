package com.jm.kakaotaxi.data.repository.api

import com.jm.kakaotaxi.data.model.QuickPlaceListModel
import com.jm.kakaotaxi.data.model.search.SearchRecentModel

interface PlaceRepository {
    suspend fun getQuickPlaces(): Result<QuickPlaceListModel>
    suspend fun getRecentPlaces(): Result<List<SearchRecentModel>>
}
