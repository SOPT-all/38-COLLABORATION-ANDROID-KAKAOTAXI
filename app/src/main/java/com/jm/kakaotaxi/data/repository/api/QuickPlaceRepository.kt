package com.jm.kakaotaxi.data.repository.api

import com.jm.kakaotaxi.data.model.QuickPlaceListModel

interface QuickPlaceRepository {
    suspend fun getQuickPlace(): Result<QuickPlaceListModel>
}