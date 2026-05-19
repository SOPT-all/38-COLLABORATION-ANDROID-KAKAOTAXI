package com.jm.kakaotaxi.data.remote.service

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.request.PostTaxiCallRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface TaxiCallService {
    @POST("/v1/rides")
    suspend fun postTaxiCall(@Body request: PostTaxiCallRequestDto): BaseResponse<Unit>
}