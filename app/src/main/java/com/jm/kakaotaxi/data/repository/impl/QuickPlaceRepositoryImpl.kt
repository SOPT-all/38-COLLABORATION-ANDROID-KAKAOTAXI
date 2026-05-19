package com.jm.kakaotaxi.data.repository.impl

import com.jm.kakaotaxi.core.util.suspendRunCatching
import com.jm.kakaotaxi.data.mapper.toQuickPlaceListModel
import com.jm.kakaotaxi.data.model.QuickPlaceListModel
import com.jm.kakaotaxi.data.remote.datasource.api.QuickPlaceRemoteDatasource
import com.jm.kakaotaxi.data.repository.api.QuickPlaceRepository

class QuickPlaceRepositoryImpl(
    private val quickPlaceRemoteDatasource: QuickPlaceRemoteDatasource
) : QuickPlaceRepository {

    override suspend fun getQuickPlace(): Result<QuickPlaceListModel> =
        suspendRunCatching {
            quickPlaceRemoteDatasource.getQuickPlace().data
                ?.toQuickPlaceListModel() ?: QuickPlaceListModel(emptyList())
        }
}