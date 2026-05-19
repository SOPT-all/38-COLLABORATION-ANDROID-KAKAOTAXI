package com.jm.kakaotaxi.data.remote.datasource.api

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.request.PostTaxiCallRequestDto

interface TaxiCallDataSource {
    suspend fun postTaxiCall(request: PostTaxiCallRequestDto): BaseResponse<Unit>
}