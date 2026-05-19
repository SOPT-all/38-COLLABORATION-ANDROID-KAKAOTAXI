package com.jm.kakaotaxi.data.repository.impl

import com.jm.kakaotaxi.core.util.suspendRunCatching
import com.jm.kakaotaxi.data.remote.datasource.api.QuickPlaceRemoteDatasource
import com.jm.kakaotaxi.data.repository.api.QuickPlaceRepository

class QuickPlaceRepositoryImpl (
    private val quickPlaceRemoteDatasource: QuickPlaceRemoteDatasource
) : QuickPlaceRepository {

    override suspend fun getQuickPlace(): Result<List<String>> =
        suspendRunCatching {
            quickPlaceRemoteDatasource.getQuickPlace().data ?: emptyList()
        }
}