package com.jm.kakaotaxi.data.remote.datasource.impl

import com.jm.kakaotaxi.data.remote.datasource.api.TaxiCallDataSource
import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.request.PostTaxiCallRequestDto
import com.jm.kakaotaxi.data.remote.service.TaxiCallService

class TaxiCallDataSourceImpl (
    private val taxiCallService: TaxiCallService,
) : TaxiCallDataSource {

    override suspend fun postTaxiCall(request: PostTaxiCallRequestDto): BaseResponse<Unit> {
        return taxiCallService.postTaxiCall(request)
    }
}