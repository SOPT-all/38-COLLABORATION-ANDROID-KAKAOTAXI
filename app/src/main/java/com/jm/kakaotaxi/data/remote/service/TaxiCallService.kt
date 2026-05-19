package com.jm.kakaotaxi.data.remote.service

import com.jm.kakaotaxi.data.remote.dto.BaseResponse
import com.jm.kakaotaxi.data.remote.dto.T
import retrofit2.Response
import retrofit2.http.GET

interface TaxiCallService {
    @GET("api/v1/rides/{taxi_id}")
    suspend fun callinfoList(): Response<BaseResponse<T>>
}
