package com.jm.kakaotaxi.data.remote.service

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.response.CallInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface TaxiCallService {

    @GET("api/v1/rides/{taxi_id}")
    suspend fun callInfo(
        @Path("taxi_id") taxiId: Int
    ): BaseResponse<CallInfo>
}