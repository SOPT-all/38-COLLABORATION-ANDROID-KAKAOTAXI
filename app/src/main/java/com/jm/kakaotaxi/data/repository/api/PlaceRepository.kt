package com.jm.kakaotaxi.data.repository.api

import com.jm.kakaotaxi.data.model.search.SearchRecentModel

interface PlaceRepository {
    suspend fun getRecentPlaces(): Result<List<SearchRecentModel>>
}
