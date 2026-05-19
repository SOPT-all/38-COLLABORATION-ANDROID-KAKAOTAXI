package com.jm.kakaotaxi.data.repository.api

import com.jm.kakaotaxi.data.model.QuickPlaceListModel

interface PlaceRepository {
    suspend fun getQuickPlaces(): Result<QuickPlaceListModel>
}