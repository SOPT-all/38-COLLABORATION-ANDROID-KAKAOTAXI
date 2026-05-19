package com.jm.kakaotaxi.data.repository.impl

import com.jm.kakaotaxi.core.util.suspendRunCatching
import com.jm.kakaotaxi.data.mapper.toQuickPlaceListModel
import com.jm.kakaotaxi.data.model.QuickPlaceListModel
import com.jm.kakaotaxi.data.remote.datasource.api.PlaceDataSource
import com.jm.kakaotaxi.data.repository.api.PlaceRepository

class PlaceRepositoryImpl(
    private val placeDataSource: PlaceDataSource
) : PlaceRepository {

    override suspend fun getQuickPlaces(): Result<QuickPlaceListModel> =
        suspendRunCatching {
            placeDataSource.getQuickPlaces().data
                ?.toQuickPlaceListModel() ?: throw IllegalArgumentException("response data is null")
        }
}