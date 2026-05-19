package com.jm.kakaotaxi.data.repository.impl

import com.jm.kakaotaxi.core.util.suspendRunCatching
import com.jm.kakaotaxi.data.mapper.toSearchRecentModel
import com.jm.kakaotaxi.data.model.search.SearchRecentModel
import com.jm.kakaotaxi.data.remote.datasource.api.PlaceDataSource
import com.jm.kakaotaxi.data.repository.api.PlaceRepository

class PlaceRepositoryImpl(
    private val placeDataSource: PlaceDataSource,
) : PlaceRepository {

    override suspend fun getRecentPlaces(): Result<List<SearchRecentModel>> =
        suspendRunCatching {
            placeDataSource.getRecentPlaces().data?.map { it.toSearchRecentModel() }
                ?: throw IllegalStateException("response data is null")
        }
}
