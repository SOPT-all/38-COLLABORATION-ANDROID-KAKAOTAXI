package com.jm.kakaotaxi.data.repository.impl

import com.jm.kakaotaxi.core.util.suspendRunCatching
import com.jm.kakaotaxi.data.remote.datasource.api.TaxiCallDataSource
import com.jm.kakaotaxi.data.remote.dto.request.PostTaxiCallRequestDto
import com.jm.kakaotaxi.data.repository.api.TaxiCallRepository

class TaxiCallRepositoryImpl(
    private val taxiCallDataSource: TaxiCallDataSource,
) : TaxiCallRepository {

    override suspend fun postTaxiCall(placeId: Int): Result<Unit> =
        suspendRunCatching {
            taxiCallDataSource.postTaxiCall(
                PostTaxiCallRequestDto(placeId = placeId)
            )
        }
}